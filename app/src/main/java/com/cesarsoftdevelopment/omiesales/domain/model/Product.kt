package com.cesarsoftdevelopment.omiesales.domain.model

import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity

data class Product(
    val id : Int,
    val productName: String,
    val quantity: Int,
    val unitValue: Double,
    val totalValue: Double
)

fun Product.asProductEntity() : ProductEntity {
    return ProductEntity(
        id = id,
        productName = productName,
        quantity = quantity,
        unitValue = unitValue,
        totalValue = totalValue,
    )
}