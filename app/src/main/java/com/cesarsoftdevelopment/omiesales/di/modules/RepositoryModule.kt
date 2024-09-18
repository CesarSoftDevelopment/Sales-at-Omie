package com.cesarsoftdevelopment.omiesales.di.modules

import com.cesarsoftdevelopment.omiesales.data.repository.ProductRepositoryImpl
import com.cesarsoftdevelopment.omiesales.data.repository.SaleRepositoryImpl
import com.cesarsoftdevelopment.omiesales.data.repository.datasource.ProductLocalDataSource
import com.cesarsoftdevelopment.omiesales.data.repository.datasource.SaleLocalDataSource
import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository
import com.cesarsoftdevelopment.omiesales.domain.repository.SaleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(
        productLocalDataSource: ProductLocalDataSource
    ) : ProductRepository {
        return ProductRepositoryImpl(
            productLocalDataSource
        )
    }

    @Singleton
    @Provides
    fun provideSaleRepository(
        saleLocalDataSource: SaleLocalDataSource
    ) : SaleRepository {
        return SaleRepositoryImpl(
            saleLocalDataSource
        )
    }

}