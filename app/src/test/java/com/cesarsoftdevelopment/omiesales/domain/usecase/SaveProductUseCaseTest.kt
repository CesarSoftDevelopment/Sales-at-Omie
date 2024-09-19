package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository
import com.cesarsoftdevelopment.omiesales.utils.TextProvider
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@RunWith(MockitoJUnitRunner::class)
class SaveProductUseCaseTest {

    @Mock
    private lateinit var productRepository: ProductRepository

    private lateinit var saveProductUseCase: SaveProductUseCase

    @Before
    fun setUp() {
        saveProductUseCase = SaveProductUseCase(productRepository)
    }


    @Test
    fun `invoke should call saveProduct in repository`() = runTest {

        val product = Product(
            id = 1,
            productName = "Test Product",
            quantity = 2,
            unitValue = 5.0,
            totalValue = 10.0
        )

        saveProductUseCase.invoke(product)

        verify(productRepository).saveProduct(product)
    }

}