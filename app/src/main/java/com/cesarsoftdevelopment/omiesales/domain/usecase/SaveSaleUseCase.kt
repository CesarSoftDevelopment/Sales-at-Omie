package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.domain.repository.SaleRepository
import com.cesarsoftdevelopment.omiesales.utils.SaleValidator

class SaveSaleUseCase(private val saleRepository: SaleRepository) {
    suspend operator fun invoke(sale: Sale) {
        SaleValidator.validate(sale)
        saleRepository.saveSale(sale)
    }

}