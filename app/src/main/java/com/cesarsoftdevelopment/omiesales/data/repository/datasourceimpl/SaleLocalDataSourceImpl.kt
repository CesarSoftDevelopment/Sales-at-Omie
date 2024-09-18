package com.cesarsoftdevelopment.omiesales.data.repository.datasourceimpl

import com.cesarsoftdevelopment.omiesales.data.database.SaleDao
import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.data.repository.datasource.SaleLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class SaleLocalDataSourceImpl(
    private val saleDao: SaleDao,
    private val ioDispatcher: CoroutineDispatcher
) : SaleLocalDataSource {

    override suspend fun saveSale(sale: Sale) {
        withContext(ioDispatcher) {
            saleDao.insertSale(sale)
        }
    }

    override fun getSales(): Flow<List<Sale>> {
        TODO("Not yet implemented")
    }


}