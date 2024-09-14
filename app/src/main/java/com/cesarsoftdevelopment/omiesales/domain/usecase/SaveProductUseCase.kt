package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository

class SaveProductUseCase(private val productRepository: ProductRepository) {
    suspend operator fun invoke(productEntity: ProductEntity) {
        productRepository.saveProduct(productEntity)
    }


}