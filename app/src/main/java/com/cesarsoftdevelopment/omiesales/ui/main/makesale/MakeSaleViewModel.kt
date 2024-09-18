package com.cesarsoftdevelopment.omiesales.ui.main.makesale

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.UpdateProductQuantityUseCase
import com.cesarsoftdevelopment.omiesales.utils.TextProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MakeSaleViewModel(
    private val saveProductUseCase: SaveProductUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    private val updateProductQuantityUseCase: UpdateProductQuantityUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
    private val saveSaleUseCase: SaveProductUseCase
) : ViewModel() {

    private val _products  = MutableStateFlow<List<Product>>(emptyList())
    val products : StateFlow<List<Product>> = _products


    fun saveProduct(product: Product) = viewModelScope.launch {
        saveProductUseCase.invoke(product)
    }

    fun validateFields(clientName : String, product: Product) {

    }

    fun getProducts() {
        viewModelScope.launch {
            getProductsUseCase.invoke().collect { productList ->
                _products.value = productList
            }
        }
    }

    fun updateProduct(productId : Int, newQuantity : Int) = viewModelScope.launch {
       updateProductQuantityUseCase.invoke(productId, newQuantity)
    }

    fun deleteProduct(productId : Int) = viewModelScope.launch {
        deleteProductUseCase.invoke(productId)
    }

    fun saveSale() {
        //TODO
    }

}