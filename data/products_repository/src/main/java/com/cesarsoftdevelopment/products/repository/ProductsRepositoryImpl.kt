package com.cesarsoftdevelopment.products.repository

import com.cesarsoftdevelopment.models.Product
import com.cesarsoftdevelopment.products.repository.datasource.ProductsLocalDataSource
import kotlinx.coroutines.flow.Flow

class ProductsRepositoryImpl(
    private val productsLocalDataSource: ProductsLocalDataSource
) : ProductsRepository {

    override suspend fun saveProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override fun getProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProductById(productId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllProducts() {
        TODO("Not yet implemented")
    }


}