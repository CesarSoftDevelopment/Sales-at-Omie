package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository

class DeleteAllProductsUseCase(private val productRepository: ProductRepository) {
    suspend operator fun invoke() {
        return productRepository.deleteAllProducts()
    }

}