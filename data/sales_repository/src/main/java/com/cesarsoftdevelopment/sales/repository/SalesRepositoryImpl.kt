package com.cesarsoftdevelopment.sales.repository

import com.cesarsoftdevelopment.sales.model.Sale
import com.cesarsoftdevelopment.sales.repository.datasource.SalesLocalDataSource
import kotlinx.coroutines.flow.Flow

class SalesRepositoryImpl(private val salesLocalDataSource: SalesLocalDataSource) : SalesRepository {

    override suspend fun saveSale(sale: com.cesarsoftdevelopment.models.Sale) {
        TODO("Not yet implemented")
    }

    override fun getSales(): Flow<List<com.cesarsoftdevelopment.models.Sale>> {
        TODO("Not yet implemented")
    }


}