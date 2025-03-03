package com.cesarsoftdevelopment.makesale.data.repository.datasourceimpl

import com.cesarsoftdevelopment.data.dao.SaleDao
import com.cesarsoftdevelopment.data.model.SaleEntity
import com.cesarsoftdevelopment.makesale.data.repository.datasource.SaleLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class SaleLocalDataSourceImpl(
    private val saleDao: SaleDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : SaleLocalDataSource {

    override suspend fun saveSale(sale: SaleEntity) {
        withContext(ioDispatcher) {
            saleDao.insertSale(sale)
        }
    }

    override fun getSales(): Flow<List<SaleEntity>> {
        return saleDao.getAllSales()
    }


}