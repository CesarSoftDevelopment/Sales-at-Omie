package com.cesarsoftdevelopment.makesale.domain.usecase

import com.cesarsoftdevelopment.makesale.domain.model.Product
import com.cesarsoftdevelopment.makesale.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val productsRepository: ProductsRepository) {
    operator fun invoke(): Flow<List<Product>> {
        return productsRepository.getProducts()
    }
}