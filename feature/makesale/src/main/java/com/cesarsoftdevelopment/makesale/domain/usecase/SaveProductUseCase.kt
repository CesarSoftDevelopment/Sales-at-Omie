package com.cesarsoftdevelopment.makesale.domain.usecase

import com.cesarsoftdevelopment.makesale.domain.model.Product
import com.cesarsoftdevelopment.makesale.domain.repository.ProductsRepository

class SaveProductUseCase(private val productsRepository: ProductsRepository)  {
    suspend operator fun invoke(product: Product) {
        productsRepository.saveProduct(product)
    }
}