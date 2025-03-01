package com.cesarsoftdevelopment.sales.usecase

import com.cesarsoftdevelopment.sales.model.Sale
import com.cesarsoftdevelopment.sales.repository.SalesRepository

class SaveSaleUseCase(private val salesRepository: SalesRepository) {
    suspend operator fun invoke(sale: Sale) {
        salesRepository.saveSale(sale)
    }

}