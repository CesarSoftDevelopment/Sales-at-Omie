package com.cesarsoftdevelopment.omiesales.di.modules

import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository
import com.cesarsoftdevelopment.omiesales.domain.repository.SaleRepository
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteAllProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetSalesUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveSaleUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.UpdateProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideSaveProductUseCase(productRepository: ProductRepository): SaveProductUseCase {
        return SaveProductUseCase(productRepository)
    }

    @Provides
    fun provideGetProductsUseCase(productRepository: ProductRepository): GetProductsUseCase {
        return GetProductsUseCase(productRepository)
    }

    @Provides
    fun provideDeleteProductUseCase(productRepository: ProductRepository): DeleteProductUseCase {
        return DeleteProductUseCase(productRepository)
    }

    @Provides
    fun provideDeleteAllProductsUseCase(productRepository: ProductRepository): DeleteAllProductsUseCase {
        return DeleteAllProductsUseCase(productRepository)
    }

    @Provides
    fun provideUpdateProductUseCase(productRepository: ProductRepository): UpdateProductUseCase {
        return UpdateProductUseCase(productRepository)
    }

    @Provides
    fun provideGetSalesUseCase(salesRepository: SaleRepository): GetSalesUseCase {
        return GetSalesUseCase(salesRepository)
    }

    @Provides
    fun provideSaveSaleUseCase(salesRepository: SaleRepository): SaveSaleUseCase {
        return SaveSaleUseCase(salesRepository)
    }

}