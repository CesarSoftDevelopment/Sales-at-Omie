package com.cesarsoftdevelopment.makesale.data.repository.datasource

import com.cesarsoftdevelopment.data.model.SaleEntity
import kotlinx.coroutines.flow.Flow

interface SaleLocalDataSource {
    suspend fun saveSale(sale: SaleEntity)
    fun getSales() : Flow<List<SaleEntity>>
}