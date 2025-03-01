package com.cesarsoftdevelopment.products.usecase

import com.cesarsoftdevelopment.products.repository.ProductsRepository

class DeleteProductUseCase(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke(productId: Int) {
        return productsRepository.deleteProductById(productId)
    }
}