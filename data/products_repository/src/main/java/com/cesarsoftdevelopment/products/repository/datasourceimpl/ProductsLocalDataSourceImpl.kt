package com.cesarsoftdevelopment.products.repository.datasourceimpl

import com.cesarsoftdevelopment.database.ProductDao
import com.cesarsoftdevelopment.models.ProductEntity
import com.cesarsoftdevelopment.products.repository.datasource.ProductsLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ProductLocalDataSourceImpl(
    private val productDao: ProductDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ProductsLocalDataSource {

    override suspend fun saveProduct(productEntity: ProductEntity) {
        withContext(dispatcher) {
            productDao.insertProduct(productEntity)
        }
    }

    override fun getProducts(): Flow<List<ProductEntity>> {
        return productDao.getAllProducts()
    }

    override suspend fun deleteProductById(productId: Int) {
        withContext(dispatcher) {
            productDao.deleteProductById(productId)
        }
    }

    override suspend fun deleteAllProducts() {
        withContext(dispatcher) {
            productDao.deleteAllProducts()
        }
    }

    override suspend fun updateProduct(productEntity: ProductEntity) {
        withContext(dispatcher) {
            productDao.updateProduct(productEntity)
        }
    }
}