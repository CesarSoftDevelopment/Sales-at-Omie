package com.cesarsoftdevelopment.data

import androidx.room.TypeConverter
import com.cesarsoftdevelopment.data.model.ProductEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {

    @TypeConverter
    fun fromProductList(products: List<ProductEntity>): String {
        val type = object : TypeToken<List<ProductEntity>>() {}.type
        return Gson().toJson(products, type)
    }

    @TypeConverter
    fun toProductList(productsString: String): List<ProductEntity> {
        val type = object : TypeToken<List<ProductEntity>>() {}.type
        return Gson().fromJson(productsString, type)
    }

}