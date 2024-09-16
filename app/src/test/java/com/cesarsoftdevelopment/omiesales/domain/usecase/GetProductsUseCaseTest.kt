package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetProductsUseCaseTest {

    @Mock
    private lateinit var productRepository: ProductRepository

    private lateinit var getProductsUseCase: GetProductsUseCase

    @Before
    fun setUp() {
        getProductsUseCase = GetProductsUseCase(productRepository)
    }

    @Test
    fun `invoke should call getProducts in repository and return flow of products`() = runTest {

        val product = Product(
            id = 1,
            productName =
            "Test Product",
            quantity = 1,
            unitValue = 10.0,
            totalValue = 10.0
        )

        val products = listOf(product)

        `when`(productRepository.getProducts()).thenReturn(flowOf(products))

        val result = getProductsUseCase.invoke()

        verify(productRepository).getProducts()

        assertEquals(products, result.first())
    }

}