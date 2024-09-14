package com.cesarsoftdevelopment.omiesales.domain.repository

import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun saveProduct(productEntity: ProductEntity)
    fun getProducts() : Flow<List<ProductEntity>>
    suspend fun updateProductQuantity(productId: Int, newQuantity: Int)
    suspend fun deleteProduct(productEntity: ProductEntity)
}