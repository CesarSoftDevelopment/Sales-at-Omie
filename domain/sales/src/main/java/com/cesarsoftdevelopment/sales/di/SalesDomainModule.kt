package com.cesarsoftdevelopment.sales.di

import com.cesarsoftdevelopment.sales.repository.SalesRepository
import com.cesarsoftdevelopment.sales.usecase.GetSalesUseCase
import com.cesarsoftdevelopment.sales.usecase.SaveSaleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SalesDomainModule {

    @Singleton
    @Provides
    fun provideGetSalesUseCase(salesRepository: SalesRepository): GetSalesUseCase {
        return GetSalesUseCase(salesRepository)
    }

    @Singleton
    @Provides
    fun provideSaveSaleUseCase(salesRepository: SalesRepository): SaveSaleUseCase {
        return SaveSaleUseCase(salesRepository)
    }

}