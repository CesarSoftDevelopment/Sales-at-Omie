package com.cesarsoftdevelopment.makesale.data.repository

import com.cesarsoftdevelopment.makesale.data.repository.datasource.SaleLocalDataSource
import com.cesarsoftdevelopment.makesale.domain.model.Sale
import com.cesarsoftdevelopment.makesale.domain.model.asSale
import com.cesarsoftdevelopment.makesale.domain.model.asSaleEntity
import com.cesarsoftdevelopment.makesale.domain.repository.SalesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SalesRepositoryImpl(
    private val saleLocalDataSource: SaleLocalDataSource
) : SalesRepository {

    override suspend fun saveSale(sale: Sale) {
        saleLocalDataSource.saveSale(sale.asSaleEntity())
    }

    override fun getSales(): Flow<List<Sale>> {
        return saleLocalDataSource.getSales().map { salesLocal ->
            salesLocal.map {
                it.asSale()
            }
        }
    }
}