package com.cesarsoftdevelopment.omiesales.ui.main.makesale

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.cesarsoftdevelopment.omiesales.R
import com.cesarsoftdevelopment.omiesales.databinding.FragmentHomeBinding
import com.cesarsoftdevelopment.omiesales.databinding.FragmentMakeSaleBinding
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.ui.main.MainActivity
import com.cesarsoftdevelopment.omiesales.utils.FormatterUtil
import com.cesarsoftdevelopment.omiesales.utils.SaleValidator
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

class MakeSaleFragment : Fragment() {

    private lateinit var makeSaleViewModel : MakeSaleViewModel
    private lateinit var makeSaleAdapter: MakeSaleAdapter
    private var _binding: FragmentMakeSaleBinding? = null
    private val binding get() = _binding!!
    private var unitValueFormatted = ""
    private var itemUnitValue = 0.0
    private var itemQuantity = 0
    private var itemValue = 0.0
    private var listItemsQuantity = 0
    private var totalOrderValue = 0.0


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
        setupTextWatchers()
        observeUnitValueFormatted()
        observeItemValueFormatted()
        observeItemQuantity()
        observeUnitValue()
        observeItemValue()
        saveProduct()
        observeErrorMessage()
        setAdapter()
        observeItemsList()
    }

    private fun setViewModel() {
        makeSaleViewModel = (activity as MainActivity).makeSaleViewModel
    }


    @SuppressLint("SetTextI18n")
    private fun observeItemValueFormatted() {
        lifecycleScope.launch  {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                makeSaleViewModel.itemValueFormatted.collect { formattedItemValue ->
                    binding.itemValue.text = "Valor total do item: $formattedItemValue"
                }
            }
        }
    }

    private fun observeErrorMessage() {
        lifecycleScope.launch  {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                makeSaleViewModel.errorMessage.collect { message ->
                    if (message.isNotBlank()) {
                        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
                        makeSaleViewModel.clearErrorMessage()
                    }
                }
            }
        }
    }

    private fun observeUnitValueFormatted() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                makeSaleViewModel.unitValueFormatted.collect { formattedValue ->
                    unitValueFormatted = formattedValue
                }
            }
        }
    }

    private fun observeItemQuantity() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                makeSaleViewModel.quantity.collect { quantity ->
                    itemQuantity = quantity
                }
            }
        }
    }

    private fun observeUnitValue() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                makeSaleViewModel.unitValue.collect { unitValue ->
                    itemUnitValue = unitValue
                }
            }
        }
    }

    private fun observeItemValue() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                makeSaleViewModel.itemValue.collect { value ->
                    itemValue = value
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun observeItemsList() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                makeSaleViewModel.items.collect { items ->
                    listItemsQuantity = items.size
                    totalOrderValue = SaleValidator.calculateTotalValue(items)

                    binding.productQuantitySale.text = "Qt de itens: $listItemsQuantity"
                    binding.totalSale.text = FormatterUtil.formatToBrazilianCurrency(totalOrderValue)
                    makeSaleAdapter.submitList(items)
                }
            }
        }
    }


    private fun setupTextWatchers() {

        binding.productQuantity.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val quantity = s.toString().toIntOrNull() ?: 0
                makeSaleViewModel.setQuantity(quantity)
            }
        })

        binding.unitProductValue.addTextChangedListener(object : TextWatcher {

            var currentValue = ""

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                val textValue = s.toString()

                if(textValue != currentValue) {

                    binding.unitProductValue.removeTextChangedListener(this)
                    makeSaleViewModel.processUnitValue(textValue)
                    currentValue = unitValueFormatted

                    binding.unitProductValue.setText(unitValueFormatted)
                    binding.unitProductValue.setSelection(unitValueFormatted.length)
                    binding.unitProductValue.addTextChangedListener(this)
                }

            }
        })
    }

    private fun saveProduct() {

        binding.btnInsert.setOnClickListener {
            val id = 0
            val clientName = binding.clientName.text.toString()
            val productName = binding.productName.text.toString()
            val productQuantity = itemQuantity
            val productUnitValue = itemUnitValue
            val productTotalValue = itemValue

            val product = Product(
                id,
                productName,
                productQuantity,
                productUnitValue,
                productTotalValue
            )

            if (makeSaleViewModel.isValidField(clientName, product)) {
                makeSaleViewModel.saveProduct(product)
                makeSaleViewModel.getProducts()
                clearFields()
            }
        }
    }

    private fun setAdapter() {
        makeSaleAdapter = MakeSaleAdapter(makeSaleViewModel)
        binding.recyclerItems.apply {
            adapter = makeSaleAdapter
        }
    }

    private fun clearFields() {
        binding.clientName.text?.clear()
        binding.productName.text?.clear()
        binding.productQuantity.text?.clear()
        binding.unitProductValue.text?.clear()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}