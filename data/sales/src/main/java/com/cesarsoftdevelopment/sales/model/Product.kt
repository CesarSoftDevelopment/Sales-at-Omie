package com.cesarsoftdevelopment.sales.model

data class Product (
    val id : Int = 0,
    val productName: String,
    val quantity: Int,
    val unitValue: Double,
    val totalValue: Double
)
