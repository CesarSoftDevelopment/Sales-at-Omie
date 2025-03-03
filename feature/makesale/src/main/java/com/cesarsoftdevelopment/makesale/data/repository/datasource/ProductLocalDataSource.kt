package com.cesarsoftdevelopment.makesale.data.repository.datasource

import com.cesarsoftdevelopment.data.model.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductLocalDataSource {
    suspend fun saveProduct(productEntity: ProductEntity)
    fun getProducts() : Flow<List<ProductEntity>>
    suspend fun deleteProductById(productId: Int)
    suspend fun deleteAllProducts()
    suspend fun updateProduct(productEntity: ProductEntity)
}