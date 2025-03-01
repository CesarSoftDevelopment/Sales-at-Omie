package com.cesarsoftdevelopment.sales.di

import com.cesarsoftdevelopment.sales.repository.SalesRepository
import com.cesarsoftdevelopment.sales.repository.SalesRepositoryImpl
import com.cesarsoftdevelopment.sales.repository.datasource.SalesLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SalesRepositoryModule {

    @Singleton
    @Provides
    fun provideSalesRepository(salesLocalDataSource: SalesLocalDataSource): SalesRepository {
        return SalesRepositoryImpl(salesLocalDataSource)
    }

}