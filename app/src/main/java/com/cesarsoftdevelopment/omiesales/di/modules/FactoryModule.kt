package com.cesarsoftdevelopment.omiesales.di.modules

import android.app.Application
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteAllProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetSalesUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveSaleUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.UpdateProductQuantityUseCase
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
        updateProductQuantityUseCase : UpdateProductQuantityUseCase,
        deleteProductUseCase : DeleteProductUseCase,
        deleteAllProductsUseCase: DeleteAllProductsUseCase,
        saveSaleUseCase: SaveSaleUseCase

    ): MakeSaleViewModelFactory {
        return MakeSaleViewModelFactory(
            saveProductUseCase,
            getProductsUseCase,
            updateProductQuantityUseCase,
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