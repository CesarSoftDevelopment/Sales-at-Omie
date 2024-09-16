package com.cesarsoftdevelopment.omiesales.data.repository

import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import com.cesarsoftdevelopment.omiesales.data.model.asProduct
import com.cesarsoftdevelopment.omiesales.data.repository.datasource.ProductLocalDataSource
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.model.asLocalProduct
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductRepositoryImplTest {

    @Mock
    private lateinit var productLocalDataSource: ProductLocalDataSource

    private lateinit var productRepository: ProductRepositoryImpl

    @Before
    fun setUp() {
        productRepository = ProductRepositoryImpl(productLocalDataSource)
    }

    @Test
    fun `saveProduct should call saveProduct in local data source`() = runTest {

        val product = Product(
            id = 1,
            productName = "Test Product",
            quantity = 1,
            unitValue = 10.0,
            totalValue = 10.0
        )

        productRepository.saveProduct(product)

        verify(productLocalDataSource).saveProduct(product.asLocalProduct())
    }

    @Test
    fun `getProducts should transform local products in products and return them`() = runTest {

        val localProducts = listOf(

            ProductEntity(
                id = 1,
                productName =
                "Test Product",
                quantity = 1,
                unitValue = 10.0,
                totalValue = 10.0
            )
        )

        val products = localProducts.map {
            it.asProduct()
        }

        `when`(productLocalDataSource.getProducts()).thenReturn(flowOf(localProducts))

        val result = productRepository.getProducts()

        assertEquals(products, result.first())

        verify(productLocalDataSource).getProducts()

    }

    @Test
    fun `updateProductQuantity should call updateProductQuantity in local data source`() = runTest {

        val productId = 1

        val newQuantity = 15

        productRepository.updateProductQuantity(productId, newQuantity)

        verify(productLocalDataSource).updateProductQuantity(productId, newQuantity)
    }

    @Test
    fun `deleteProduct should call deleteProduct in local data source`() = runTest {

        val productId = 1

        productRepository.deleteProductById(productId)

        verify(productLocalDataSource).deleteProductById(productId)
    }
}