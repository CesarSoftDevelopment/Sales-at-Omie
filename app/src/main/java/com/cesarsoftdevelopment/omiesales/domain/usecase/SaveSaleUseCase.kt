package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.domain.repository.SaleRepository

class SaveSaleUseCase(private val saleRepository: SaleRepository) {
    suspend operator fun invoke(sale: Sale) {
        saleRepository.saveSale(sale)
    }

}