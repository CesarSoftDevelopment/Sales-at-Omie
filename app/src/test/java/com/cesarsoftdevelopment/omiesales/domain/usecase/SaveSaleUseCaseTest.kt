package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.repository.ProductRepository
import com.cesarsoftdevelopment.omiesales.domain.repository.SaleRepository
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
import kotlin.test.assertFailsWith

@RunWith(MockitoJUnitRunner::class)
class SaveSaleUseCaseTest {

    @Mock
    private lateinit var saleRepository: SaleRepository

    private lateinit var saveSaleUseCase: SaveSaleUseCase

    @Before
    fun setUp() {
        saveSaleUseCase = SaveSaleUseCase(saleRepository)
    }

    @Test
    fun `invoke should throw IllegalArgumentException when clientName is empty`() = runTest {

        val client = "João"

        val totalPrice  = 0.0

        val product = Product(
            id = 1,
            productName = "",
            quantity = 2,
            unitValue = 5.0,
            totalValue = 10.0
        )

        val sale = Sale(
            clientName = client,
            totalPrice = totalPrice,
            products = listOf(product)
        )


        assertFailsWith<IllegalArgumentException>(TextProvider.CLIENT_NAME_EMPTY) {
            saveSaleUseCase.invoke(sale)
        }

        verify(saleRepository,never()).saveSale(any())

    }

}