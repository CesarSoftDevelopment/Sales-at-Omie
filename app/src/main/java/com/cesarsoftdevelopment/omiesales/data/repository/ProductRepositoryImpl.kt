package com.cesarsoftdevelopment.omiesales.data.repository

import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import com.cesarsoftdevelopment.omiesales.data.repository.datasource.ProductLocalDataSource
import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    private val productLocalDataSource: ProductLocalDataSource
) : ProductRepository {

    override suspend fun saveProduct(productEntity: ProductEntity) {
        TODO("Not yet implemented")
    }

    override fun getProducts(): Flow<List<ProductEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateProductQuantity(productId: Int, newQuantity: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(productEntity: ProductEntity) {
        TODO("Not yet implemented")
    }


}