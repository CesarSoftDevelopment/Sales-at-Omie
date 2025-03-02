package com.cesarsoftdevelopment.products.di

import com.cesarsoftdevelopment.products.repository.ProductsRepository
import com.cesarsoftdevelopment.products.usecase.DeleteAllProductsUseCase
import com.cesarsoftdevelopment.products.usecase.DeleteProductUseCase
import com.cesarsoftdevelopment.products.usecase.GetProductsUseCase
import com.cesarsoftdevelopment.products.usecase.ProductsUseCase
import com.cesarsoftdevelopment.products.usecase.SaveProductUseCase
import com.cesarsoftdevelopment.products.usecase.UpdateProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductsDomainModule {

    @Singleton
    @Provides
    fun provideProductsUseCase(productsRepository: ProductsRepository): ProductsUseCase {
        return ProductsUseCase(
            getProductsUseCase = GetProductsUseCase(productsRepository),
            saveProductUseCase = SaveProductUseCase(productsRepository),
            updateProductUseCase = UpdateProductUseCase(productsRepository),
            deleteProductUseCase = DeleteProductUseCase(productsRepository),
            deleteAllProductsUseCase = DeleteAllProductsUseCase(productsRepository),
        )
    }

}