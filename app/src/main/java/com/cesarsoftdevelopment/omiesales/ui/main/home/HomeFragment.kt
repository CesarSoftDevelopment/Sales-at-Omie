package com.cesarsoftdevelopment.omiesales.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleOnBackPressed()
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

    private fun handleOnBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}