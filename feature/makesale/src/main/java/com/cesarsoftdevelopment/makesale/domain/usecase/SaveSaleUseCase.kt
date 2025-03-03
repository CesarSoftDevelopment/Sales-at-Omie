package com.cesarsoftdevelopment.makesale.domain.usecase

import com.cesarsoftdevelopment.makesale.domain.model.Sale
import com.cesarsoftdevelopment.makesale.domain.repository.SalesRepository

class SaveSaleUseCase(private val salesRepository: SalesRepository) {
    suspend operator fun invoke(sale: Sale) {
        salesRepository.saveSale(sale)
    }

}