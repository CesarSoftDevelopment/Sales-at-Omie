package com.cesarsoftdevelopment.omiesales.ui.main.saleshistory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetSalesUseCase

class SalesHistoryViewModelFactory(
    private val getSalesUseCase: GetSalesUseCase
) : ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SalesHistoryViewModel(
            getSalesUseCase
        ) as T
    }

}