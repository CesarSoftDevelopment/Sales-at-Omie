package com.cesarsoftdevelopment.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cesarsoftdevelopment.data.Converters
import com.cesarsoftdevelopment.data.dao.ProductDao
import com.cesarsoftdevelopment.data.dao.SaleDao
import com.cesarsoftdevelopment.data.model.ProductEntity
import com.cesarsoftdevelopment.data.model.SaleEntity

@Database(entities = [SaleEntity::class, ProductEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class OmieSalesDatabase : RoomDatabase() {
    abstract fun getSaleDao(): SaleDao
    abstract fun getProductDao(): ProductDao
}