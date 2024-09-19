package com.cesarsoftdevelopment.omiesales.ui.main.saleshistory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.domain.usecase.GetSalesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SalesHistoryViewModel (private val getSalesUseCase: GetSalesUseCase): ViewModel() {

    private val _sales  = MutableStateFlow<List<Sale>>(emptyList())
    val sales : StateFlow<List<Sale>> = _sales


    init {
        getSales()
    }

    private fun getSales() {
        viewModelScope.launch {
            getSalesUseCase.invoke().collect { itemsList ->
                _sales.value = itemsList
            }
        }
    }
}