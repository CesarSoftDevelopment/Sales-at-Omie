package com.cesarsoftdevelopment.products.repository.datasource

import com.cesarsoftdevelopment.products.model.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductsLocalDataSource {
    suspend fun saveProduct(productEntity: ProductEntity)
    fun getProducts() : Flow<List<ProductEntity>>
    suspend fun deleteProductById(productId: Int)
    suspend fun deleteAllProducts()
    suspend fun updateProduct(productEntity: ProductEntity)
}