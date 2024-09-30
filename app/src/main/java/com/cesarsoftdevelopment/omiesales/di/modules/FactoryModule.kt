package com.cesarsoftdevelopment.omiesales.di.modules

import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteAllProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetSalesUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveSaleUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.UpdateProductUseCase
import com.cesarsoftdevelopment.omiesales.ui.main.makesale.MakeSaleViewModelFactory
import com.cesarsoftdevelopment.omiesales.ui.main.saleshistory.SalesHistoryViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideMakeSaleViewModelFactory(
        saveProductUseCase : SaveProductUseCase,
        getProductsUseCase : GetProductsUseCase,
        updateProductUseCase : UpdateProductUseCase,
        deleteProductUseCase : DeleteProductUseCase,
        deleteAllProductsUseCase: DeleteAllProductsUseCase,
        saveSaleUseCase: SaveSaleUseCase

    ): MakeSaleViewModelFactory {
        return MakeSaleViewModelFactory(
            saveProductUseCase,
            getProductsUseCase,
            updateProductUseCase,
            deleteProductUseCase,
            deleteAllProductsUseCase,
            saveSaleUseCase
        )
    }

    @Singleton
    @Provides
    fun provideSalesHistoryViewModelFactory(
        getSalesUseCase: GetSalesUseCase
    ): SalesHistoryViewModelFactory {
        return SalesHistoryViewModelFactory(
            getSalesUseCase
        )
    }

}