package com.cesarsoftdevelopment.sales.repository

import com.cesarsoftdevelopment.models.Sale
import kotlinx.coroutines.flow.Flow

interface SalesRepository {
    suspend fun saveSale(sale : Sale)
    fun getSales() : Flow<List<Sale>>
}