package com.cesarsoftdevelopment.makesale.domain.usecase

import com.cesarsoftdevelopment.makesale.domain.repository.ProductsRepository

class DeleteProductUseCase(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke(productId: Int) {
        return productsRepository.deleteProductById(productId)
    }
}