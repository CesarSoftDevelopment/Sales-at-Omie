package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository

class UpdateProductUseCase(private val productRepository: ProductRepository) {
    suspend fun invoke(product : Product) {
        productRepository.updateProduct(product)
    }


}