package com.cesarsoftdevelopment.makesale.domain.repository

import com.cesarsoftdevelopment.makesale.domain.model.Sale
import kotlinx.coroutines.flow.Flow

interface SalesRepository {
    suspend fun saveSale(sale : Sale)
    fun getSales() : Flow<List<Sale>>
}