package com.cesarsoftdevelopment.omiesales.utils

import androidx.room.TypeConverter
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {

    @TypeConverter
    fun fromProductList(products: List<Product>): String {
        val type = object : TypeToken<List<Product>>() {}.type
        return Gson().toJson(products, type)
    }

    @TypeConverter
    fun toProductList(productsString: String): List<Product> {
        val type = object : TypeToken<List<Product>>() {}.type
        return Gson().fromJson(productsString, type)
    }

}