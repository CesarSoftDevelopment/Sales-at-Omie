package com.cesarsoftdevelopment.omiesales.data.repository.datasource

import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductLocalDataSource {
    suspend fun saveProduct(productEntity: ProductEntity)
    fun getProducts() : Flow<List<ProductEntity>>
    suspend fun deleteProduct(product: ProductEntity)
    suspend fun updateProductQuantity(productId: Int, newQuantity: Int)

}