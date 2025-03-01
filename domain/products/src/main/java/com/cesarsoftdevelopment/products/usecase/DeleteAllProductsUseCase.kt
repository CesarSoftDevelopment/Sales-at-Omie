package com.cesarsoftdevelopment.products.usecase

import com.cesarsoftdevelopment.products.repository.ProductsRepository

class DeleteAllProductsUseCase(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke() {
        return productsRepository.deleteAllProducts()
    }
}