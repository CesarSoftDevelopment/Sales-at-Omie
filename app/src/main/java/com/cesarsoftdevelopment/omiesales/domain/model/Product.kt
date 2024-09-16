package com.cesarsoftdevelopment.omiesales.domain.model

import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity

data class Product(
    val id : Int = 0,
    val productName: String,
    val quantity: Int,
    val unitValue: Double,
    val totalValue: Double
)

fun Product.asLocalProduct() : ProductEntity {
    return ProductEntity(
        id = id,
        productName = productName,
        quantity = quantity,
        unitValue = unitValue,
        totalValue = totalValue,
    )
}