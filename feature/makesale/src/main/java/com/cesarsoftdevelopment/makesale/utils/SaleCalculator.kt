package com.cesarsoftdevelopment.makesale.utils

import com.cesarsoftdevelopment.makesale.domain.model.Product
import com.cesarsoftdevelopment.makesale.domain.model.Sale

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