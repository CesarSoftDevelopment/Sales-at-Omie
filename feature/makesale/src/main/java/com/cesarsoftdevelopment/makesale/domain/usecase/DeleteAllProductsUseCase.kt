package com.cesarsoftdevelopment.makesale.domain.usecase

import com.cesarsoftdevelopment.makesale.domain.repository.ProductsRepository

class DeleteAllProductsUseCase(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke() {
        return productsRepository.deleteAllProducts()
    }
}