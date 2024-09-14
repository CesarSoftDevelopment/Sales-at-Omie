package com.cesarsoftdevelopment.omiesales.data.repository.datasourceimpl

import com.cesarsoftdevelopment.omiesales.data.database.ProductDao
import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class ProductLocalDataSourceImplTest {

    @Mock
    private lateinit var productDao: ProductDao

    private lateinit var productLocalDataSource: ProductLocalDataSourceImpl

    @Before
    fun setUp() {
        productLocalDataSource = ProductLocalDataSourceImpl(productDao, Dispatchers.Unconfined)
    }


    @Test
    fun `getProducts should return a list of products`() = runTest {

        val productList = listOf(ProductEntity(
            id = 1,
            productName =
            "Test Product",
            quantity = 1,
            unitValue = 10.0,
            totalValue = 10.0
        ))

        `when`(productDao.getAllProducts()).thenReturn(flowOf(productList))

        val result = productLocalDataSource.getProducts().first()

        assertEquals(productList, result)
    }

}