package com.cesarsoftdevelopment.makesale.domain.usecase

import com.cesarsoftdevelopment.makesale.domain.model.Sale
import com.cesarsoftdevelopment.makesale.domain.repository.SalesRepository
import kotlinx.coroutines.flow.Flow

class GetSalesUseCase (private val salesRepository: SalesRepository) {
    operator fun invoke(): Flow<List<Sale>> {
        return salesRepository.getSales()
    }
}