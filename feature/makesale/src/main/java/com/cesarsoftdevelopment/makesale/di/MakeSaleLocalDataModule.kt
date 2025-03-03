package com.cesarsoftdevelopment.makesale.di

import com.cesarsoftdevelopment.data.dao.ProductDao
import com.cesarsoftdevelopment.data.dao.SaleDao
import com.cesarsoftdevelopment.makesale.data.repository.datasource.ProductLocalDataSource
import com.cesarsoftdevelopment.makesale.data.repository.datasource.SaleLocalDataSource
import com.cesarsoftdevelopment.makesale.data.repository.datasourceimpl.ProductLocalDataSourceImpl
import com.cesarsoftdevelopment.makesale.data.repository.datasourceimpl.SaleLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MakeSaleLocalDataModule {

    @Singleton
    @Provides
    fun provideProductLocalDataSource(productDao: ProductDao): ProductLocalDataSource {
        return ProductLocalDataSourceImpl(productDao)
    }

    @Singleton
    @Provides
    fun provideSaleLocalDataSource(saleDao: SaleDao): SaleLocalDataSource {
        return SaleLocalDataSourceImpl(saleDao)
    }

}