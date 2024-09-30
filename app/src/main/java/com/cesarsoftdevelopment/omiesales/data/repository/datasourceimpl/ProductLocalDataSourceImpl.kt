package com.cesarsoftdevelopment.omiesales.data.repository.datasourceimpl

import com.cesarsoftdevelopment.omiesales.data.database.ProductDao
import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import com.cesarsoftdevelopment.omiesales.data.repository.datasource.ProductLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ProductLocalDataSourceImpl(
    private val productDao: ProductDao,
    private val ioDispatcher: CoroutineDispatcher
) : ProductLocalDataSource {

    override suspend fun saveProduct(productEntity: ProductEntity) {
        withContext(ioDispatcher) {
            productDao.insertProduct(productEntity)
        }

    }

    override fun getProducts(): Flow<List<ProductEntity>> {
        return productDao.getAllProducts()
    }

    override suspend fun deleteProductById(productId: Int) {
        withContext(ioDispatcher) {
            productDao.deleteProductById(productId)
        }
    }

    override suspend fun deleteAllProducts() {
        withContext(ioDispatcher) {
            productDao.deleteAllProducts()
        }
    }

    override suspend fun updateProduct(productEntity: ProductEntity) {
        withContext(ioDispatcher) {
            productDao.updateProduct(productEntity)
        }
    }
}