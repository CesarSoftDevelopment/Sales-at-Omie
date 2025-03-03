package com.cesarsoftdevelopment.makesale.domain.model

import com.cesarsoftdevelopment.data.model.ProductEntity

data class Product (
    val id : Int = 0,
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

fun ProductEntity.asProduct() : Product {
    return Product(
        id = id,
        productName = productName,
        quantity = quantity,
        unitValue = unitValue,
        totalValue = totalValue,
    )
}