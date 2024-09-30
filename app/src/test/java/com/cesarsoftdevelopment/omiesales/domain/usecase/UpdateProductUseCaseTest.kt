package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UpdateProductUseCaseTest {

    @Mock
    private lateinit var productRepository: ProductRepository

    private lateinit var updateProductQuantityUseCase: UpdateProductUseCase

    @Before
    fun setUp() {
        updateProductQuantityUseCase = UpdateProductUseCase(productRepository)
    }

    @Test
    fun `invoke should call deleteProduct in repository`() = runTest {

        val product = Product(
            id = 1,
            productName =
            "Test Product",
            quantity = 1,
            unitValue = 10.0,
            totalValue = 10.0
        )

        updateProductQuantityUseCase.invoke(product)

        verify(productRepository).updateProduct(product)
    }

}