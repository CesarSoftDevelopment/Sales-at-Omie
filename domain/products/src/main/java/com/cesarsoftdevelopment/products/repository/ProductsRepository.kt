package com.cesarsoftdevelopment.products.repository

import com.cesarsoftdevelopment.products.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun saveProduct(product: Product)
    fun getProducts() : Flow<List<Product>>
    suspend fun updateProduct(product: Product)
    suspend fun deleteProductById(productId: Int)
    suspend fun deleteAllProducts()
}