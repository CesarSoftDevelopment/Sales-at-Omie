package com.cesarsoftdevelopment.omiesales.domain.usecase

import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.domain.repository.SaleRepository
import kotlinx.coroutines.flow.Flow

class GetSalesUseCase (private val saleRepository: SaleRepository) {
    operator fun invoke(): Flow<List<Sale>> {
        return saleRepository.getSales()
    }


}