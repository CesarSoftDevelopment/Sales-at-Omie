package com.cesarsoftdevelopment.makesale.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cesarsoftdevelopment.makesale.databinding.ProductItemBinding
import com.cesarsoftdevelopment.makesale.domain.model.Product
import com.cesarsoftdevelopment.makesale.presentation.viewmodel.MakeSaleViewModel
import com.cesarsoftdevelopment.makesale.utils.FormatterUtil

class MakeSaleAdapter (
    private val makeSaleViewModel: MakeSaleViewModel
) : ListAdapter<Product, MakeSaleAdapter.ViewHolder>(MakeSaleDiffCallback()) {

    class MakeSaleDiffCallback : DiffUtil.ItemCallback<Product>() {

        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    class ViewHolder private constructor(
        private val binding: ProductItemBinding,
        private val makeSaleViewModel: MakeSaleViewModel
    ): RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item : Product) {
            binding.productName.text = item.productName
            binding.productQuantity.text = item.quantity.toString()
            binding.productUnitValue.text = "Valor unitário: ${FormatterUtil.formatToBrazilianCurrency(item.unitValue)}"
            binding.productTotalValue.text = "Valor total: ${FormatterUtil.formatToBrazilianCurrency(item.totalValue)}"

            val product = Product(
                item.id,
                item.productName,
                item.quantity,
                item.unitValue,
                item.totalValue
            )

            binding.ibTrash.setOnClickListener {
                makeSaleViewModel.deleteProduct(item.id)
            }

            binding.ibPlus.setOnClickListener {
                makeSaleViewModel.updateProduct(product, true)
            }

            binding.ibMinus.setOnClickListener {
                makeSaleViewModel.updateProduct(product, false)
            }

        }

        companion object {
            fun from(parent: ViewGroup, makeSaleViewModel: MakeSaleViewModel): ViewHolder {
                val binding = ProductItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

                return ViewHolder(
                    binding,
                    makeSaleViewModel
                )
            }
        }
    }

}