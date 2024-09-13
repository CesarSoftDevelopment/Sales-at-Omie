package com.cesarsoftdevelopment.omiesales.ui.main.saleshistory

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cesarsoftdevelopment.omiesales.R

class SalesHistoryFragment : Fragment() {

    private val viewModel: SalesHistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_sales_history, container, false)
    }
}