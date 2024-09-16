package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val productRepository: ProductRepository) {
    operator fun invoke(): Flow<List<Product>> {
        return productRepository.getProducts()
    }
}