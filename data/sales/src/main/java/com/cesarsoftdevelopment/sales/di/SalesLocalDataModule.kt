package com.cesarsoftdevelopment.sales.di

import com.cesarsoftdevelopment.database.SaleDao
import com.cesarsoftdevelopment.sales.repository.datasource.SalesLocalDataSource
import com.cesarsoftdevelopment.sales.repository.datasourceimpl.SalesLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SalesLocalDataModule {

    @Singleton
    @Provides
    fun provideSalesLocalDataSource(saleDao: SaleDao): SalesLocalDataSource {
        return SalesLocalDataSourceImpl(saleDao)
    }
}