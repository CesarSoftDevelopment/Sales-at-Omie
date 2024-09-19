package com.cesarsoftdevelopment.omiesales.data.repository

import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.data.repository.datasource.SaleLocalDataSource
import com.cesarsoftdevelopment.omiesales.domain.model.asLocalProduct
import com.cesarsoftdevelopment.omiesales.domain.repository.SaleRepository
import kotlinx.coroutines.flow.Flow

class SaleRepositoryImpl(
    private val saleLocalDataSource: SaleLocalDataSource
) : SaleRepository {

    override suspend fun saveSale(sale: Sale) {
        saleLocalDataSource.saveSale(sale)
    }

    override fun getSales(): Flow<List<Sale>> {
        return saleLocalDataSource.getSales()
    }


}