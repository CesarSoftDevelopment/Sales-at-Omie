package com.cesarsoftdevelopment.sales.repository.datasource

import com.cesarsoftdevelopment.sales.model.Sale
import kotlinx.coroutines.flow.Flow

interface SalesLocalDataSource {
    suspend fun saveSale(sale: Sale)
    fun getSales() : Flow<List<Sale>>
}