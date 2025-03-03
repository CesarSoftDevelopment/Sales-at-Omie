package com.cesarsoftdevelopment.sales.usecase

import com.cesarsoftdevelopment.models.Sale
import com.cesarsoftdevelopment.sales.repository.SalesRepository
import kotlinx.coroutines.flow.Flow

class GetSalesUseCase (private val salesRepository: SalesRepository) {
    operator fun invoke(): Flow<List<Sale>> {
        return salesRepository.getSales()
    }
}