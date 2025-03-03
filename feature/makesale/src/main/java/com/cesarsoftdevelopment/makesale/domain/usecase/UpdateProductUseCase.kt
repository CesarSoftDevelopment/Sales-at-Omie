package com.cesarsoftdevelopment.makesale.domain.usecase

import com.cesarsoftdevelopment.makesale.domain.model.Product
import com.cesarsoftdevelopment.makesale.domain.repository.ProductsRepository

class UpdateProductUseCase(private val productsRepository: ProductsRepository) {
    suspend fun invoke(product : Product) {
        productsRepository.updateProduct(product)
    }
}