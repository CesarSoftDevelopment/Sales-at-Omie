package com.cesarsoftdevelopment.sales.repository.datasourceimpl

import com.cesarsoftdevelopment.database.SaleDao
import com.cesarsoftdevelopment.sales.model.Sale
import com.cesarsoftdevelopment.sales.repository.datasource.SalesLocalDataSource
import kotlinx.coroutines.flow.Flow

class SalesLocalDataSourceImpl(private val saleDao: SaleDao) : SalesLocalDataSource {

    override suspend fun saveSale(sale: Sale) {
        TODO("Not yet implemented")
    }

    override fun getSales(): Flow<List<Sale>> {
        TODO("Not yet implemented")
    }

}