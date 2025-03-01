package com.cesarsoftdevelopment.products.usecase

import com.cesarsoftdevelopment.products.model.Product
import com.cesarsoftdevelopment.products.repository.ProductsRepository

class SaveProductUseCase(private val productsRepository: ProductsRepository)  {
    suspend operator fun invoke(product: Product) {
        productsRepository.saveProduct(product)
    }
}