package com.cesarsoftdevelopment.omiesales.di.modules

import com.cesarsoftdevelopment.omiesales.data.database.ProductDao
import com.cesarsoftdevelopment.omiesales.data.database.SaleDao
import com.cesarsoftdevelopment.omiesales.data.repository.datasource.ProductLocalDataSource
import com.cesarsoftdevelopment.omiesales.data.repository.datasource.SaleLocalDataSource
import com.cesarsoftdevelopment.omiesales.data.repository.datasourceimpl.ProductLocalDataSourceImpl
import com.cesarsoftdevelopment.omiesales.data.repository.datasourceimpl.SaleLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideProductLocalDataSource(
        productDao: ProductDao,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): ProductLocalDataSource {
        return ProductLocalDataSourceImpl(productDao, ioDispatcher)
    }

    @Singleton
    @Provides
    fun provideSaleLocalDataSource(
        saleDao: SaleDao,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): SaleLocalDataSource {
        return SaleLocalDataSourceImpl(saleDao, ioDispatcher)
    }

}