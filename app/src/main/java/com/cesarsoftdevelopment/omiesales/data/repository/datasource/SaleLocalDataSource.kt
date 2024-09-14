package com.cesarsoftdevelopment.omiesales.data.repository.datasource

import com.cesarsoftdevelopment.omiesales.data.model.Sale
import kotlinx.coroutines.flow.Flow

interface SaleLocalDataSource {
    suspend fun saveSale(sale: Sale)
    fun getProducts() : Flow<List<Sale>>
}