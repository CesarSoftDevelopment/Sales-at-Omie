package com.cesarsoftdevelopment.products.di

import com.cesarsoftdevelopment.database.ProductDao
import com.cesarsoftdevelopment.products.repository.datasource.ProductsLocalDataSource
import com.cesarsoftdevelopment.products.repository.datasourceimpl.ProductLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductsLocalDataModule {

    @Singleton
    @Provides
    fun provideProductsLocalDataSource(productDao: ProductDao): ProductsLocalDataSource {
        return ProductLocalDataSourceImpl(productDao)
    }

}