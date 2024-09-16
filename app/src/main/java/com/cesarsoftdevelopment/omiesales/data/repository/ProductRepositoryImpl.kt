package com.cesarsoftdevelopment.omiesales.data.repository

import com.cesarsoftdevelopment.omiesales.data.model.asProduct
import com.cesarsoftdevelopment.omiesales.data.repository.datasource.ProductLocalDataSource
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.model.asLocalProduct
import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepositoryImpl(
    private val productLocalDataSource: ProductLocalDataSource
) : ProductRepository {

    override suspend fun saveProduct(product: Product) {
        productLocalDataSource.saveProduct(product.asLocalProduct())
    }

    override fun getProducts(): Flow<List<Product>> {
        return productLocalDataSource.getProducts().map { localProducts ->
            localProducts.map {
                it.asProduct()
            }
        }
    }

    override suspend fun updateProductQuantity(productId: Int, newQuantity: Int) {
        productLocalDataSource.updateProductQuantity(
            productId,
            newQuantity
        )
    }

    override suspend fun deleteProductById(productId: Int) {
        productLocalDataSource.deleteProductById(productId)
    }


}