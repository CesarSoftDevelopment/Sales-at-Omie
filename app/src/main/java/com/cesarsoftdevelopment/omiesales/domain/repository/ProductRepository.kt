package com.cesarsoftdevelopment.omiesales.domain.repository

import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun saveProduct(product: Product)
    fun getProducts() : Flow<List<Product>>
    suspend fun updateProductQuantity(productId: Int, newQuantity: Int)
    suspend fun deleteProductById(productId: Int)
    suspend fun deleteAllProducts()
}