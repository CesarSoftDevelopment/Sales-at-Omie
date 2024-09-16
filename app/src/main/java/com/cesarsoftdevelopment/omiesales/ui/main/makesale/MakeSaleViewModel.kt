package com.cesarsoftdevelopment.omiesales.ui.main.makesale

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.UpdateProductQuantityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MakeSaleViewModel(
    application: Application,
    private val saveProductUseCase: SaveProductUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    private val updateProductQuantityUseCase: UpdateProductQuantityUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
    private val saveSaleUseCase: SaveProductUseCase
) : AndroidViewModel(application) {

    private val _products  = MutableStateFlow<List<Product>>(emptyList())
    val products : StateFlow<List<Product>> = _products


    fun insertProduct(product: Product) {
        //TODO
    }

    fun getProducts() {
        //TODO
    }

    fun updateProduct() {
        //TODO
    }

    fun deleteProduct() {
        //TODO
    }

    fun saveSale() {

    }

}