package com.cesarsoftdevelopment.omiesales.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.cesarsoftdevelopment.omiesales.R
import com.cesarsoftdevelopment.omiesales.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setUpNavigation()
        return binding.root
    }

    private fun setUpNavigation() {
        navigateToCreateSale()
        navigateToSales()
    }

    private fun navigateToCreateSale() {
        binding.mcCreateSale.setOnClickListener {
            it.findNavController().navigate(
                HomeFragmentDirections.actionNavigationHomeToNavigationMakeSale()
            )
        }
    }

    private fun navigateToSales() {
        binding.mcSales.setOnClickListener {
            it.findNavController().navigate(
                HomeFragmentDirections.actionNavigationHomeToNavigationSaleHistory()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}