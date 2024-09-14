package com.cesarsoftdevelopment.omiesales.data.repository.datasourceimpl

import com.cesarsoftdevelopment.omiesales.data.database.ProductDao
import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import com.cesarsoftdevelopment.omiesales.data.repository.datasource.ProductLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class ProductLocalDataSourceImpl(
    private val productDao: ProductDao,
    private val ioDispatcher: CoroutineDispatcher
) : ProductLocalDataSource {

    override suspend fun saveProduct(productEntity: ProductEntity) {
        TODO("Not yet implemented")
    }

    override fun getProducts(): Flow<List<ProductEntity>> {
        return productDao.getAllProducts()
    }

    override suspend fun deleteProduct(product: ProductEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun updateProductQuantity(productId: Int, newQuantity: Int) {
        TODO("Not yet implemented")
    }
}