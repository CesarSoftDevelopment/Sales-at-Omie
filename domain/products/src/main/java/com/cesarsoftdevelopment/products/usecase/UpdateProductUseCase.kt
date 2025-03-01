package com.cesarsoftdevelopment.products.usecase

import com.cesarsoftdevelopment.products.model.Product
import com.cesarsoftdevelopment.products.repository.ProductsRepository

class UpdateProductUseCase(private val productsRepository: ProductsRepository) {
    suspend fun invoke(product : Product) {
        productsRepository.updateProduct(product)
    }
}