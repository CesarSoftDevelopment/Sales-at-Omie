package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository

class DeleteProductUseCase(private val productRepository: ProductRepository) {
    suspend operator fun invoke(productId: Int) {
        return productRepository.deleteProductById(productId)
    }

}