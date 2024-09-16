package com.cesarsoftdevelopment.omiesales.utils

import com.cesarsoftdevelopment.omiesales.domain.model.Product

object ProductValidator {

    fun validate(product: Product) {
        if (product.productName.isBlank()) {
            throw IllegalArgumentException(TextProvider.PRODUCT_NAME_EMPTY)
        }

        if (product.quantity <= 0) {
            throw IllegalArgumentException(TextProvider.QUANTITY_LESS_THAN_ZERO)
        }

        if (product.unitValue <= 0.0) {
            throw IllegalArgumentException(TextProvider.UNIT_VALUE_LESS_THAN_ZERO)
        }
    }
}

