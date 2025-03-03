package com.cesarsoftdevelopment.makesale.domain.usecase

data class ProductsUseCase (
    val getProductsUseCase: GetProductsUseCase,
    val saveProductUseCase: SaveProductUseCase,
    val updateProductUseCase: UpdateProductUseCase,
    val deleteProductUseCase: DeleteProductUseCase,
    val deleteAllProductsUseCase: DeleteAllProductsUseCase,
)