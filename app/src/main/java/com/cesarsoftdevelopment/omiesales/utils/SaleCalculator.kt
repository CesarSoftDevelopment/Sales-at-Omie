package com.cesarsoftdevelopment.omiesales.utils

import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.domain.model.Product

object SaleCalculator {

    fun calculateTotalProducts(items: List<Product>) : Double {
        return items.sumOf {
            it.totalValue
        }
    }

    fun calculateTotalSales(items: List<Sale>) : Double {
        return items.sumOf {
            it.totalPrice
        }
    }

}