package com.cesarsoftdevelopment.makesale.data.repository

import com.cesarsoftdevelopment.makesale.data.repository.datasource.ProductLocalDataSource
import com.cesarsoftdevelopment.makesale.domain.model.Product
import com.cesarsoftdevelopment.makesale.domain.model.asProduct
import com.cesarsoftdevelopment.makesale.domain.model.asProductEntity
import com.cesarsoftdevelopment.makesale.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductsRepositoryImpl(
    private val productLocalDataSource: ProductLocalDataSource
) : ProductsRepository {

    override suspend fun saveProduct(product: Product) {
        productLocalDataSource.saveProduct(product.asProductEntity())
    }

    override fun getProducts(): Flow<List<Product>> {
        return productLocalDataSource.getProducts().map { localProducts ->
            localProducts.map {
                it.asProduct()
            }
        }
    }

    override suspend fun updateProduct(product: Product) {
        productLocalDataSource.updateProduct(product.asProductEntity())
    }

    override suspend fun deleteProductById(productId: Int) {
        productLocalDataSource.deleteProductById(productId)
    }

    override suspend fun deleteAllProducts() {
        productLocalDataSource.deleteAllProducts()
    }

}