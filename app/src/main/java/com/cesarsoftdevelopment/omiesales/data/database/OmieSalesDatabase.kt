package com.cesarsoftdevelopment.omiesales.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.utils.Converters

@Database(entities = [Sale::class, ProductEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class OmieSalesDatabase : RoomDatabase() {
    abstract fun getSaleDao(): SaleDao
    abstract fun getProductDao(): ProductDao
}