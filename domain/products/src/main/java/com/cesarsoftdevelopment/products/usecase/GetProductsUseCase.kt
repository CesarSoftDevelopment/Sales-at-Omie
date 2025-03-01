package com.cesarsoftdevelopment.products.usecase

import com.cesarsoftdevelopment.products.model.Product
import com.cesarsoftdevelopment.products.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val productsRepository: ProductsRepository) {
    operator fun invoke(): Flow<List<Product>> {
        return productsRepository.getProducts()
    }
}