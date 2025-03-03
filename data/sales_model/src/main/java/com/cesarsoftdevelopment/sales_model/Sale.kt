package com.cesarsoftdevelopment.sales_model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cesarsoftdevelopment.product_model.Product

@Entity(tableName = "sale")
data class Sale(
    @PrimaryKey(autoGenerate = true) val saleId: Int = 0,
    val clientName: String,
    val totalPrice: Double,
    val products: List<Product>
)
