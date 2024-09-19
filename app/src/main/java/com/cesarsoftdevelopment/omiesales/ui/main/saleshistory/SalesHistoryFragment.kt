package com.cesarsoftdevelopment.omiesales.ui.main.saleshistory

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.databinding.FragmentSalesHistoryBinding
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.ui.main.MainActivity
import com.cesarsoftdevelopment.omiesales.ui.main.makesale.MakeSaleFragmentDirections
import com.cesarsoftdevelopment.omiesales.ui.main.makesale.MakeSaleViewModel
import com.cesarsoftdevelopment.omiesales.utils.FormatterUtil
import com.cesarsoftdevelopment.omiesales.utils.SaleValidator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SalesHistoryFragment : Fragment() {

    private lateinit var salesHistoryViewModel : SalesHistoryViewModel
    private var _binding: FragmentSalesHistoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var salesHistoryAdapter : SalesHistoryAdapter

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
        setViewModel()
        setAdapter()
        observeItemsList()
    }

    @SuppressLint("SetTextI18n")
    private fun observeItemsList() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                salesHistoryViewModel.sales.collect { salesList ->
                    val totalSales = SaleValidator.calculateTotalSales(salesList)
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

    private fun setViewModel() {
        salesHistoryViewModel = (activity as MainActivity).salesHistoryViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}