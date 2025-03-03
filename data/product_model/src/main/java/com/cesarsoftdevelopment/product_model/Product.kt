package com.cesarsoftdevelopment.product_model

data class Product (
    val id : Int = 0,
    val productName: String,
    val quantity: Int,
    val unitValue: Double,
    val totalValue: Double
)
