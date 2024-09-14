package com.cesarsoftdevelopment.omiesales.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cesarsoftdevelopment.omiesales.domain.model.Product

@Entity(tableName = "sale")
data class Sale(
    @PrimaryKey(autoGenerate = true) val saleId: Int = 0,
    val clientName: String,
    val totalPrice: Double,
    val products: List<Product>
)