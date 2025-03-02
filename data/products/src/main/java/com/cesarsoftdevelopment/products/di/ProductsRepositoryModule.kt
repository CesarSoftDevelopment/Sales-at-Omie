package com.cesarsoftdevelopment.products.di

import com.cesarsoftdevelopment.products.repository.ProductsRepository
import com.cesarsoftdevelopment.products.repository.ProductsRepositoryImpl
import com.cesarsoftdevelopment.products.repository.datasource.ProductsLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductsRepositoryModule {

    @Singleton
    @Provides
    fun provideProductsRepository(productsLocalDataSource: ProductsLocalDataSource): ProductsRepository {
        return ProductsRepositoryImpl(productsLocalDataSource)
    }

}