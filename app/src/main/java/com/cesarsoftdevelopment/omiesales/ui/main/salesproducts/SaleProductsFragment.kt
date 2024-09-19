package com.cesarsoftdevelopment.omiesales.ui.main.salesproducts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cesarsoftdevelopment.omiesales.databinding.FragmentSaleProductsBinding

class SaleProductsFragment : Fragment() {

    private var _binding: FragmentSaleProductsBinding? = null
    private val binding get() = _binding!!
    private lateinit var salesProductAdapter : SalesProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSaleProductsBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        getArgs()
    }

    private fun getArgs() {
        val args = SaleProductsFragmentArgs.fromBundle(requireArguments())
        val productList = args.productList
        salesProductAdapter.submitList(productList.toList())

    }

    private fun setAdapter() {
        salesProductAdapter = SalesProductAdapter()
        binding.recyclerSalesProducts.adapter = salesProductAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}