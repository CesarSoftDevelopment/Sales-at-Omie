package com.cesarsoftdevelopment.sales.model

import com.cesarsoftdevelopment.models.Product

data class Sale(
    val saleId: Int = 0,
    val clientName: String,
    val totalPrice: Double,
    val products: List<Product>
)