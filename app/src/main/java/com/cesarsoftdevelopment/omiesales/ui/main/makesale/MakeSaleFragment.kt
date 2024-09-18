package com.cesarsoftdevelopment.omiesales.ui.main.makesale

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

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
        setupTextWatchers()
        observeTotalValue()
        saveProduct()
        observeErrorMessage()

    }

    private fun setViewModel() {
        makeSaleViewModel = (activity as MainActivity).makeSaleViewModel
    }

    private fun saveProduct() {
        binding.btnInsert.setOnClickListener {
            val clientName = binding.clientName.text.toString()
            val id = 0
            val productName = binding.productName.text.toString()
            val productQuantity = binding.productQuantity.text.toString().toIntOrNull() ?: 0
            val productUnitValue = binding.unitProductValue.text.toString().toDoubleOrNull() ?: 0.0
            val productTotalValue = productUnitValue * productQuantity

            val product = Product(
                id,
                productName,
                productQuantity,
                productUnitValue,
                productTotalValue
            )

            if (makeSaleViewModel.isValidField(clientName, product)) {
                makeSaleViewModel.saveProduct(product)
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

    @SuppressLint("SetTextI18n")
    private fun observeTotalValue() {
        lifecycleScope.launch  {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                makeSaleViewModel.itemValue.collect { formattedItemValue ->
                    binding.itemValue.text = "Valor total do item: $formattedItemValue"
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

            var current = ""

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                val textValue = s.toString()

                if(textValue != current) {

                    binding.unitProductValue.removeTextChangedListener(this)

                    val cleanString = textValue.replace("[^\\d]".toRegex(), "")

                    val parsed = cleanString.toDouble()

                    makeSaleViewModel.setUnitValue(parsed)

                    val formatted = FormatterUtil.formatToBrazilianCurrency(parsed)

                    current = formatted
                    binding.unitProductValue.setText(formatted)
                    binding.unitProductValue.setSelection(formatted.length)
                    binding.unitProductValue.addTextChangedListener(this)
                }

            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}