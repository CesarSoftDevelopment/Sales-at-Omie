package com.cesarsoftdevelopment.omiesales.utils

import com.cesarsoftdevelopment.omiesales.data.model.Sale

object SaleValidator {

    fun validate(sale: Sale) {
        if (sale.clientName.isBlank()) {
            throw IllegalArgumentException(TextProvider.CLIENT_NAME_EMPTY)
        }

        if (sale.products.isEmpty()) {
            throw IllegalArgumentException(TextProvider.CLIENT_NAME_EMPTY)
        }
    }

}