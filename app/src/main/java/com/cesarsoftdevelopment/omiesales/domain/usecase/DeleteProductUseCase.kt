package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository

class DeleteProductUseCase(private val productRepository: ProductRepository) {
    suspend operator fun invoke(productEntity: ProductEntity) {
        return productRepository.deleteProduct(productEntity)
    }

}