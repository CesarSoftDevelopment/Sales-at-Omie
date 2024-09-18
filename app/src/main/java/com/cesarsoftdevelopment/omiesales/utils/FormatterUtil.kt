package com.cesarsoftdevelopment.omiesales.utils

import java.text.NumberFormat
import java.util.Locale

object FormatterUtil {

    fun formatToBrazilianCurrency(value: Double): String {
        val brazilianLocale = Locale("pt", "BR")
        val currencyFormatter = NumberFormat.getCurrencyInstance(brazilianLocale)
        return currencyFormatter.format(value / 100)
    }
}