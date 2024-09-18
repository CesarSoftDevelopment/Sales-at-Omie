package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository
import com.cesarsoftdevelopment.omiesales.utils.ProductValidator
import com.cesarsoftdevelopment.omiesales.utils.Resource
import com.cesarsoftdevelopment.omiesales.utils.TextProvider

class SaveProductUseCase(private val productRepository: ProductRepository)  {

    suspend operator fun invoke(product: Product) {
        productRepository.saveProduct(product)
    }
}