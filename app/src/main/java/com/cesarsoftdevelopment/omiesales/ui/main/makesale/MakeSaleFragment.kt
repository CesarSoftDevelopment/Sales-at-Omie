package com.cesarsoftdevelopment.omiesales.ui.main.makesale

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cesarsoftdevelopment.omiesales.R
import com.cesarsoftdevelopment.omiesales.databinding.FragmentHomeBinding
import com.cesarsoftdevelopment.omiesales.databinding.FragmentMakeSaleBinding
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.ui.main.MainActivity

class MakeSaleFragment : Fragment() {

    private lateinit var makeSaleViewModel : MakeSaleViewModel

    private var _binding: FragmentMakeSaleBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMakeSaleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        saveProducts()
    }

    private fun setViewModel() {
        makeSaleViewModel = (activity as MainActivity).makeSaleViewModel
    }

    private fun saveProducts() {

        binding.btnInsert.setOnClickListener {

            val clientName = binding.clientName.text.toString()
            val id = 0
            val productName = binding.productName.text.toString()
            //val productQuantity = binding.productQuantity.text.toString().toInt()
            val productQuantity = 2
            //val productUnitValue = binding.unitProductValue.text.toString().toDouble()
            val productUnitValue = 1.0
            //val productTotalValue = productUnitValue * productQuantity
            val productTotalValue = 2.0

            val product = Product(
                id,
                productName,
                productQuantity,
                productUnitValue,
                productTotalValue
            )

            makeSaleViewModel.saveProduct(product)
        }
    }

    private fun validateFields(clientName : String, product: Product) {
        makeSaleViewModel.validateFields(clientName, product)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}