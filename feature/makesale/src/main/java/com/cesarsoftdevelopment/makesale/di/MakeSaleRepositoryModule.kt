package com.cesarsoftdevelopment.makesale.di

import com.cesarsoftdevelopment.makesale.data.repository.ProductsRepositoryImpl
import com.cesarsoftdevelopment.makesale.data.repository.SalesRepositoryImpl
import com.cesarsoftdevelopment.makesale.data.repository.datasource.ProductLocalDataSource
import com.cesarsoftdevelopment.makesale.data.repository.datasource.SaleLocalDataSource
import com.cesarsoftdevelopment.makesale.domain.repository.ProductsRepository
import com.cesarsoftdevelopment.makesale.domain.repository.SalesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MakeSaleRepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(productLocalDataSource: ProductLocalDataSource) : ProductsRepository {
        return ProductsRepositoryImpl(productLocalDataSource)
    }

    @Singleton
    @Provides
    fun provideSaleRepository(saleLocalDataSource: SaleLocalDataSource) : SalesRepository {
        return SalesRepositoryImpl(saleLocalDataSource)
    }

}