package com.cesarsoftdevelopment.omiesales.data.repository.datasourceimpl

import com.cesarsoftdevelopment.omiesales.data.database.SaleDao
import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.data.repository.datasource.SaleLocalDataSource
import kotlinx.coroutines.flow.Flow

class SaleLocalDataSourceImpl(private val dao: SaleDao) : SaleLocalDataSource {

    override suspend fun saveSale(sale: Sale) {
        TODO("Not yet implemented")
    }

    override fun getProducts(): Flow<List<Sale>> {
        TODO("Not yet implemented")
    }


}