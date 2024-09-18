package com.cesarsoftdevelopment.omiesales.ui.main.makesale

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteAllProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.UpdateProductQuantityUseCase
import com.cesarsoftdevelopment.omiesales.utils.FormatterUtil
import com.cesarsoftdevelopment.omiesales.utils.TextProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MakeSaleViewModel(
    private val saveProductUseCase: SaveProductUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    private val updateProductQuantityUseCase: UpdateProductQuantityUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
    private val deleteAllProductsUseCase : DeleteAllProductsUseCase,
    private val saveSaleUseCase: SaveProductUseCase
) : ViewModel() {

    private val _items  = MutableStateFlow<List<Product>>(emptyList())
    val items : StateFlow<List<Product>> = _items

    private val _quantity  = MutableStateFlow(0)
    val quantity : StateFlow<Int> = _quantity

    private val _unitValue  = MutableStateFlow(0.0)
    val unitValue : StateFlow<Double> = _unitValue

    private val _unitValueFormatted = MutableStateFlow("R$ 0,00")
    val unitValueFormatted: StateFlow<String> = _unitValueFormatted

    private val _itemValue = MutableStateFlow(0.0)
    val itemValue : StateFlow<Double> = _itemValue

    private val _itemValueFormatted = MutableStateFlow("R$ 0,00")
    val itemValueFormatted : StateFlow<String> = _itemValueFormatted

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    fun processUnitValue(textValue: String) {

        val cleanString = textValue.replace("[^\\d]".toRegex(), "")

        val parsed = cleanString.toDoubleOrNull() ?: 0.0

        _unitValue.value = parsed

        calculateTotal()

        val formatted = FormatterUtil.formatToBrazilianCurrency(parsed)

        _unitValueFormatted.value = formatted
    }


    fun setQuantity(quantity: Int) {
        _quantity.value = quantity
        calculateTotal()
    }

    private fun calculateTotal() {
        val total = _quantity.value * _unitValue.value
        _itemValueFormatted.value = FormatterUtil.formatToBrazilianCurrency(total)
        _itemValue.value = total
    }


    fun isValidField(clientName : String, product: Product) : Boolean {

        val error = when {
            clientName.isBlank() -> TextProvider.CLIENT_NAME_EMPTY
            product.productName.isBlank() -> TextProvider.PRODUCT_NAME_EMPTY
            product.quantity <= 0 -> TextProvider.QUANTITY_LESS_THAN_ZERO
            product.unitValue <= 0 ->  TextProvider.UNIT_VALUE_LESS_THAN_ZERO
            product.totalValue <= 0 -> TextProvider.TOTAL_VALUE_LESS_THAN_ZERO
            else -> null
        }

        return if (error != null) {
            _errorMessage.value = error
            false
        } else {
            _errorMessage.value = ""
            true
        }

    }

    fun clearErrorMessage() {
        _errorMessage.value = ""
    }

    fun saveProduct(product: Product) = viewModelScope.launch {
        saveProductUseCase.invoke(product)
    }

    fun getProducts() {
        viewModelScope.launch {
            getProductsUseCase.invoke().collect { itemsList ->
                _items.value = itemsList
            }
        }
    }

    fun updateProduct(productId : Int, newQuantity : Int) = viewModelScope.launch {
       updateProductQuantityUseCase.invoke(productId, newQuantity)
    }

    fun deleteProduct(productId : Int) = viewModelScope.launch {
        deleteProductUseCase.invoke(productId)
    }

    fun deleteAllProducts() = viewModelScope.launch {
        deleteAllProductsUseCase.invoke()
    }


    fun saveSale() {
        //TODO
    }

}