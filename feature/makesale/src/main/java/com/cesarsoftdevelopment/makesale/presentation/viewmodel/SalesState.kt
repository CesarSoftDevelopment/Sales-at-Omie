package com.cesarsoftdevelopment.makesale.presentation.viewmodel

import com.cesarsoftdevelopment.makesale.domain.model.Product

data class SalesState(
    val items: List<Product> = emptyList(),
    val quantity: Int = 0,
    val unitValue: Double = 0.0,
    val discountValue: Double = 0.0,
    val unitValueFormatted: String = "R$ 0,00",
    val discountValueFormatted: String = "R$ 0,00",
    val itemValue: Double = 0.0,
    val itemValueFormatted: String = "R$ 0,00",
    val errorMessage: String = ""
)

