package com.cesarsoftdevelopment.omiesales.ui.main.makesale

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteAllProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveSaleUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.UpdateProductUseCase
import com.cesarsoftdevelopment.omiesales.utils.FormatterUtil
import com.cesarsoftdevelopment.omiesales.utils.TextProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MakeSaleViewModel(
    private val saveProductUseCase: SaveProductUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
    private val deleteAllProductsUseCase : DeleteAllProductsUseCase,
    private val saveSaleUseCase: SaveSaleUseCase
) : ViewModel() {

    private val _salesState = MutableStateFlow(SalesState())
    val salesState: StateFlow<SalesState> = _salesState

    fun processUnitValue(textValue: String) {
        val cleanString = textValue.replace("[^\\d]".toRegex(), "")
        val parsed = cleanString.toDoubleOrNull() ?: 0.0
        val formatted = FormatterUtil.formatToBrazilianCurrency(parsed)

        _salesState.update { currentState ->
            currentState.copy(unitValue = parsed, unitValueFormatted = formatted)
        }

       calculateItemTotal()
    }

    fun processDiscountValue(textValue: String) {
        val cleanString = textValue.replace("[^\\d]".toRegex(), "")
        val parsed = cleanString.toDoubleOrNull() ?: 0.0
        val formatted = FormatterUtil.formatToBrazilianCurrency(parsed)

        _salesState.update { currentState ->
            currentState.copy(discountValue = parsed, discountValueFormatted = formatted)
        }

        calculateItemTotal()
    }


    fun setQuantity(quantity: Int) {
        _salesState.update { currentState ->
            currentState.copy(quantity = quantity)
        }

        calculateItemTotal()
    }

    private fun calculateItemTotal() {
        val total = _salesState.value.quantity * _salesState.value.unitValue

        _salesState.update { currentState ->
            currentState.copy(
                itemValueFormatted = FormatterUtil.formatToBrazilianCurrency(total),
                itemValue = total
            )
        }
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
            _salesState.update { currentState ->
                currentState.copy(errorMessage = error)
            }
            false
        } else {
            _salesState.update { currentState ->
                currentState.copy(errorMessage = "")
            }
            true
        }

    }

    fun validateFieldsToMakeSale(clientName : String, listSize : Int) : Boolean {

        if(clientName.isBlank()) {
            _salesState.update { currentState ->
                currentState.copy(errorMessage = TextProvider.CLIENT_NAME_EMPTY)
            }
            return false
        }

        if(listSize <= 0) {
            _salesState.update { currentState ->
                currentState.copy(errorMessage = TextProvider.LIST_EMPTY)
            }
            return false
        }
        return true
    }


    fun clearErrorMessage() {
        _salesState.update { currentState ->
            currentState.copy(errorMessage = "")
        }
    }

    fun saveProduct(product: Product) = viewModelScope.launch {
        saveProductUseCase.invoke(product)
    }

    fun getProducts() {
        viewModelScope.launch {
            getProductsUseCase.invoke().collect { itemsList ->
                _salesState.update { currentState ->
                    currentState.copy(
                        items = itemsList
                    )
                }
            }
        }
    }

    fun updateProduct(product: Product, isSum : Boolean) = viewModelScope.launch {
        var quantity = product.quantity

        if(isSum) {
            quantity += 1
        }else {
            if (quantity > 1) {
                quantity -= 1
            }
        }


        val totalValue = product.unitValue * quantity
        val item = Product(
            product.id,
            product.productName,
            quantity,
            product.unitValue,
            totalValue
        )

        updateProductUseCase.invoke(item)
    }

    fun updateDiscountProduct(product: Product) = viewModelScope.launch {

        //val totalValue = product.unitValue * product.quantity - _discountValue.value
        val totalValue = 0.0

        val item = Product(
            product.id,
            product.productName,
            product.quantity,
            product.unitValue,
            totalValue
        )
        updateProductUseCase.invoke(item)
    }


    fun deleteProduct(productId : Int) = viewModelScope.launch {
        deleteProductUseCase.invoke(productId)
    }

    fun deleteAllProducts() = viewModelScope.launch {
        deleteAllProductsUseCase.invoke()
    }

    fun saveSale(sale: Sale) = viewModelScope.launch {
        saveSaleUseCase.invoke(sale)
    }

}