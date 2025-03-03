package com.cesarsoftdevelopment.makesale.domain.repository

import com.cesarsoftdevelopment.makesale.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun saveProduct(product: Product)
    fun getProducts() : Flow<List<Product>>
    suspend fun updateProduct(product: Product)
    suspend fun deleteProductById(productId: Int)
    suspend fun deleteAllProducts()
}