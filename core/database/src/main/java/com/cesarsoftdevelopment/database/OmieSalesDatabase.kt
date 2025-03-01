package com.cesarsoftdevelopment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cesarsoftdevelopment.products.model.ProductEntity
import com.cesarsoftdevelopment.sales.model.Sale
import com.cesarsoftdevelopment.utils.Converters

@Database(entities = [Sale::class, ProductEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class OmieSalesDatabase : RoomDatabase() {
    abstract fun getSaleDao(): SaleDao
    abstract fun getProductDao(): ProductDao
}