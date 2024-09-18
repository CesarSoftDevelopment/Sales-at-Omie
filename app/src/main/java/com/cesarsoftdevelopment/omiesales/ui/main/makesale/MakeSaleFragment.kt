package com.cesarsoftdevelopment.omiesales.ui.main.makesale

import android.annotation.SuppressLint
import android.graphics.Color
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
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import com.cesarsoftdevelopment.omiesales.R
import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.databinding.FragmentHomeBinding
import com.cesarsoftdevelopment.omiesales.databinding.FragmentMakeSaleBinding
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.ui.main.MainActivity
import com.cesarsoftdevelopment.omiesales.ui.main.home.HomeFragmentDirections
import com.cesarsoftdevelopment.omiesales.utils.FormatterUtil
import com.cesarsoftdevelopment.omiesales.utils.SaleValidator
import com.google.android.material.snackbar.Snackbar
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
    private var listItems = listOf<Product>()


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
        handleOnBackPressed()
        handleWhenCancelButtonIsClicked()
        saveSale()
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
                    listItems = items
                    totalOrderValue = SaleValidator.calculateTotalValue(items)

                    binding.productQuantitySale.text = "Qt de itens: $listItemsQuantity"
                    binding.totalSale.text = "Valor total: ${FormatterUtil.formatToBrazilianCurrency(totalOrderValue)}"
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
                binding.clientName.isEnabled = false
            }
        }
    }


    private fun saveSale() {
        binding.btnSaveSale.setOnClickListener {
            val clientName = binding.clientName.text.toString()
            val listSize = listItemsQuantity

            if(makeSaleViewModel.validateFieldsToMakeSale(clientName, listSize)) {

                val sale = Sale(
                    0,
                    clientName,
                    totalOrderValue,
                    listItems,
                )

                makeSaleViewModel.saveSale(sale)
                makeSaleViewModel.deleteAllProducts()
                binding.clientName.text?.clear()
                binding.clientName.isEnabled = true
                showSnackBarWithAction()
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
        binding.productName.text?.clear()
        binding.productQuantity.text?.clear()
        binding.unitProductValue.text?.clear()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        makeSaleViewModel.deleteAllProducts()
        _binding = null
    }

    private fun createAlertDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Cancelar pedido.")
        builder.setMessage("Você perderá os itens adicionados na lista. Deseja sair?")

        builder.setPositiveButton("Sim") { dialog, which ->
            makeSaleViewModel.deleteAllProducts()
            navigateToHomeFragment()
        }


        builder.setNegativeButton("Não") { dialog, which ->
            dialog.dismiss()
        }


        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun showSnackBarWithAction() {

        val rootView = requireView()

        val snackbar = Snackbar.make(
            rootView,
            "Venda feita com sucesso!",
            Snackbar.LENGTH_LONG
        )

        snackbar.setAction("Voltar") {
            navigateToHomeFragment()
        }

        snackbar.setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.green))
        snackbar.setActionTextColor(Color.WHITE)
        snackbar.show()

    }

    private fun handleWhenCancelButtonIsClicked() {
       binding.btnCancel.setOnClickListener {
           if(listItemsQuantity > 0) {
               createAlertDialog()
           }else {
               navigateToHomeFragment()
           }
       }
    }

    private fun handleOnBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if(listItemsQuantity > 0) {
                    createAlertDialog()
                }else {
                    navigateToHomeFragment()
                }
            }
        })
    }

    private fun navigateToHomeFragment() {
        requireView().findNavController().navigate(
            MakeSaleFragmentDirections.actionNavigationMakeSaleToNavigationHome()
        )
    }

}