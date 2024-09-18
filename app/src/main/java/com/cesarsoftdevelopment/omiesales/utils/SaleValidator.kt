package com.cesarsoftdevelopment.omiesales.utils

import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.domain.model.Product

object SaleValidator {

    fun validate(sale: Sale) {
        if (sale.clientName.isBlank()) {
            throw IllegalArgumentException(TextProvider.CLIENT_NAME_EMPTY)
        }

        if (sale.products.isEmpty()) {
            throw IllegalArgumentException(TextProvider.CLIENT_NAME_EMPTY)
        }
    }

    fun calculateTotalValue(items: List<Product>) : Double {
        return items.sumOf {
            it.totalValue
        }
    }
}