package com.cesarsoftdevelopment.omiesales.di.modules

import android.app.Application
import androidx.room.Room
import com.cesarsoftdevelopment.omiesales.data.database.OmieSalesDatabase
import com.cesarsoftdevelopment.omiesales.data.database.ProductDao
import com.cesarsoftdevelopment.omiesales.data.database.SaleDao
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
        return Room.databaseBuilder(application, OmieSalesDatabase::class.java, "tracking_db")
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