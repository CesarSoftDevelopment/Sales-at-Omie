package com.cesarsoftdevelopment.makesale.domain.model

import com.cesarsoftdevelopment.data.model.SaleEntity

data class Sale (
    val saleId: Int = 0,
    val clientName: String,
    val totalPrice: Double,
    val products: List<Product>
)

fun Sale.asSaleEntity() : SaleEntity {
    return SaleEntity(
        saleId = saleId,
        clientName = clientName,
        totalPrice = totalPrice,
        products = products.map { it.asProductEntity() }
    )
}

fun SaleEntity.asSale() : Sale {
    return Sale (
        saleId = saleId,
        clientName = clientName,
        totalPrice = totalPrice,
        products = products.map { it.asProduct() }
    )
}