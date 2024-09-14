package com.cesarsoftdevelopment.omiesales.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cesarsoftdevelopment.omiesales.domain.model.Product

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val productName: String,
    val quantity: Int,
    val unitValue: Double,
    val totalValue: Double
)

fun ProductEntity.asProduct() : Product {
    return Product(
        id = id,
        productName = productName,
        quantity = quantity,
        unitValue = unitValue,
        totalValue = totalValue,
    )
}