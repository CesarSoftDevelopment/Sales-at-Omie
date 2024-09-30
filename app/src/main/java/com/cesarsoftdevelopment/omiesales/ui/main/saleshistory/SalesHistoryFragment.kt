package com.cesarsoftdevelopment.omiesales.ui.main.saleshistory

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import com.cesarsoftdevelopment.omiesales.databinding.FragmentSalesHistoryBinding
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.ui.main.MainActivity
import com.cesarsoftdevelopment.omiesales.utils.FormatterUtil
import com.cesarsoftdevelopment.omiesales.utils.SaleCalculator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SalesHistoryFragment : Fragment() {

    private var _binding: FragmentSalesHistoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var salesHistoryAdapter : SalesHistoryAdapter

    @Inject
    lateinit var salesHistoryViewModelFactory : SalesHistoryViewModelFactory

    private val salesHistoryViewModel: SalesHistoryViewModel by viewModels {
        salesHistoryViewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSalesHistoryBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        observeItemsList()
    }

    @SuppressLint("SetTextI18n")
    private fun observeItemsList() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                salesHistoryViewModel.sales.collect { salesList ->
                    val totalSales = SaleCalculator.calculateTotalSales(salesList)
                    binding.totalSales.text = "Total de vendas: ${FormatterUtil.formatToBrazilianCurrency(totalSales)}"
                    salesHistoryAdapter.submitList(salesList)
                }
            }
        }
    }

    private fun setAdapter() {

        salesHistoryAdapter = SalesHistoryAdapter(SalesHistoryAdapter.OnClickListener { products ->
            navigateToSalesProducts(products)
        })

        binding.recyclerSales.adapter = salesHistoryAdapter

    }

    private fun navigateToSalesProducts(products : List<Product>) {
        requireView().findNavController().navigate(
            SalesHistoryFragmentDirections.actionNavigationSaleHistoryToSaleProductsFragment(
                products.toTypedArray()
            )
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}