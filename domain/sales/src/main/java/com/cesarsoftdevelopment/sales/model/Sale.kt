package com.cesarsoftdevelopment.sales.model

data class Sale(
    val saleId: Int = 0,
    val clientName: String,
    val totalPrice: Double,
    val products: List<ProductSale>
)