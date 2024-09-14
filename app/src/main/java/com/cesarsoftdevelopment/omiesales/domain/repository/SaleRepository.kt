package com.cesarsoftdevelopment.omiesales.domain.repository

import com.cesarsoftdevelopment.omiesales.data.model.Sale
import kotlinx.coroutines.flow.Flow

interface SaleRepository {
    suspend fun saveSale(sale : Sale)
    fun getSales() : Flow<List<Sale>>
}