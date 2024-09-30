package com.cesarsoftdevelopment.omiesales.ui.main.makesale

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteAllProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.DeleteProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetProductsUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveProductUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.SaveSaleUseCase
import com.cesarsoftdevelopment.omiesales.domain.usecase.UpdateProductUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MakeSaleViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MakeSaleViewModel
    private val saveProductUseCase = mockk<SaveProductUseCase>()
    private val getProductsUseCase = mockk<GetProductsUseCase>()
    private val updateProductUseCase = mockk<UpdateProductUseCase>()
    private val deleteProductUseCase = mockk<DeleteProductUseCase>()
    private val deleteAllProductsUseCase= mockk<DeleteAllProductsUseCase>()
    private val saveSaleUseCase = mockk<SaveSaleUseCase>()


    @Before
    fun setUp() {

       Dispatchers.setMain(Dispatchers.Unconfined)

        viewModel = MakeSaleViewModel(
            saveProductUseCase,
            getProductsUseCase,
            updateProductUseCase,
            deleteProductUseCase,
            deleteAllProductsUseCase,
            saveSaleUseCase
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `saveProduct should call saveProductUseCase`() {

        val product = Product(
            1,
            "Test Product",
            1,
            10.0,
            10.0
        )

        coEvery { saveProductUseCase.invoke(product) } returns Unit

        viewModel.saveProduct(product)

        coVerify {
            saveProductUseCase.invoke(product)
        }
    }

    @Test
    fun `getProducts should update the products flow`() {

        val productList = listOf(
            Product(1,
                "Test Product",
                1, 10.0,
                10.0)
        )

        coEvery { getProductsUseCase.invoke() } returns flowOf(productList)

        viewModel.getProducts()

        assert(viewModel.items.value == productList)
    }

    @Test
    fun `updateProduct should call updateProductUseCase`()  {

        val product = Product(
            1,
            "Test Product",
            1,
            10.0,
            10.0
        )

        coEvery { updateProductUseCase.invoke(product) } returns Unit

        viewModel.updateProduct(product, false)

        coVerify {
            updateProductUseCase.invoke(product)
        }
    }

    @Test
    fun `deleteProduct should call deleteProductUseCase`() = runTest {

        val productId = 1

        coEvery { deleteProductUseCase.invoke(productId) } returns Unit

        viewModel.deleteProduct(productId)

        coVerify {
            deleteProductUseCase.invoke(productId)
        }
    }

}