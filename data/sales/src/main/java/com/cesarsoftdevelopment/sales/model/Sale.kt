package com.cesarsoftdevelopment.sales.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sale")
data class Sale(
    @PrimaryKey(autoGenerate = true) val saleId: Int = 0,
    val clientName: String,
    val totalPrice: Double,
    val products: List<Product>
)
