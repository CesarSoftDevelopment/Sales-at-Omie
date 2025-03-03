package com.cesarsoftdevelopment.data.di

import android.app.Application
import androidx.room.Room
import com.cesarsoftdevelopment.data.dao.ProductDao
import com.cesarsoftdevelopment.data.dao.SaleDao
import com.cesarsoftdevelopment.data.database.OmieSalesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideOmieSalesDatabase(application: Application) : OmieSalesDatabase {
        return Room.databaseBuilder(application, OmieSalesDatabase::class.java, "omnie_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideProductDao(omieSalesDatabase: OmieSalesDatabase) : ProductDao {
        return omieSalesDatabase.getProductDao()
    }

    @Singleton
    @Provides
    fun provideSaleDao(omieSalesDatabase: OmieSalesDatabase) : SaleDao {
        return omieSalesDatabase.getSaleDao()
    }

}