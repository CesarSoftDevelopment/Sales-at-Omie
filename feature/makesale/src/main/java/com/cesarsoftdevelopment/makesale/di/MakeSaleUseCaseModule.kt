package com.cesarsoftdevelopment.makesale.di

import com.cesarsoftdevelopment.makesale.domain.repository.ProductsRepository
import com.cesarsoftdevelopment.makesale.domain.repository.SalesRepository
import com.cesarsoftdevelopment.makesale.domain.usecase.DeleteAllProductsUseCase
import com.cesarsoftdevelopment.makesale.domain.usecase.DeleteProductUseCase
import com.cesarsoftdevelopment.makesale.domain.usecase.GetProductsUseCase
import com.cesarsoftdevelopment.makesale.domain.usecase.GetSalesUseCase
import com.cesarsoftdevelopment.makesale.domain.usecase.ProductsUseCase
import com.cesarsoftdevelopment.makesale.domain.usecase.SalesUseCase
import com.cesarsoftdevelopment.makesale.domain.usecase.SaveProductUseCase
import com.cesarsoftdevelopment.makesale.domain.usecase.SaveSaleUseCase
import com.cesarsoftdevelopment.makesale.domain.usecase.UpdateProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MakeSaleUseCaseModule {

    @Provides
    fun provideProductsUseCase(productRepository: ProductsRepository): ProductsUseCase {
        return ProductsUseCase(
            saveProductUseCase = SaveProductUseCase(productRepository),
            getProductsUseCase = GetProductsUseCase(productRepository),
            deleteProductUseCase = DeleteProductUseCase(productRepository),
            deleteAllProductsUseCase = DeleteAllProductsUseCase(productRepository),
            updateProductUseCase = UpdateProductUseCase(productRepository),
        )
    }

    @Provides
    fun provideSalesUseCase(salesRepository: SalesRepository): SalesUseCase {
        return SalesUseCase(
           saveSaleUseCase = SaveSaleUseCase(salesRepository),
           getSalesUseCase = GetSalesUseCase(salesRepository),
        )
    }

}