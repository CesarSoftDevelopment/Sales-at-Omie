package com.cesarsoftdevelopment.makesale.viewmodel

import com.cesarsoftdevelopment.sales.model.ProductSale

data class SalesState(
    val items: List<ProductSale> = emptyList(),
    val quantity: Int = 0,
    val unitValue: Double = 0.0,
    val discountValue: Double = 0.0,
    val unitValueFormatted: String = "R$ 0,00",
    val discountValueFormatted: String = "R$ 0,00",
    val itemValue: Double = 0.0,
    val itemValueFormatted: String = "R$ 0,00",
    val errorMessage: String = ""
)

