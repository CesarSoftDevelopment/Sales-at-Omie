package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository

class UpdateProductQuantityUseCase(private val productRepository: ProductRepository) {
    suspend fun invoke(productId: Int, newQuantity: Int) {
        productRepository.updateProductQuantity(productId, newQuantity)
    }


}