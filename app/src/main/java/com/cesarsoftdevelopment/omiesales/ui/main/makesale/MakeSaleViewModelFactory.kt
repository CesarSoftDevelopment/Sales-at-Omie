package com.cesarsoftdevelopment.omiesales.ui.main.makesale

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteAllProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveSaleUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.UpdateProductUseCase

class MakeSaleViewModelFactory(
    private val saveProductUseCase: SaveProductUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    private val updateProductQuantityUseCase: UpdateProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
    private val deleteAllProductsUseCase: DeleteAllProductsUseCase,
    private val saveSaleUseCase: SaveSaleUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MakeSaleViewModel(
            saveProductUseCase,
            getProductsUseCase,
            updateProductQuantityUseCase,
            deleteProductUseCase,
            deleteAllProductsUseCase,
            saveSaleUseCase
        ) as T
    }

}