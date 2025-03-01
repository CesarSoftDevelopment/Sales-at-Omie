package com.cesarsoftdevelopment.makesale.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cesarsoftdevelopment.makesale.databinding.ProductItemBinding
import com.cesarsoftdevelopment.makesale.viewmodel.MakeSaleViewModel
import com.cesarsoftdevelopment.sales.model.ProductSale
import com.cesarsoftdevelopment.utils.FormatterUtil

class MakeSaleAdapter (
    private val makeSaleViewModel: MakeSaleViewModel
) : ListAdapter<ProductSale, MakeSaleAdapter.ViewHolder>(MakeSaleDiffCallback()) {

    class MakeSaleDiffCallback : DiffUtil.ItemCallback<ProductSale>() {

        override fun areItemsTheSame(oldItem: ProductSale, newItem: ProductSale): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductSale, newItem: ProductSale): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeSaleAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MakeSaleAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    class ViewHolder private constructor(
        private val binding: ProductItemBinding,
        private val makeSaleViewModel: MakeSaleViewModel
    ): RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item : ProductSale) {
            binding.productName.text = item.productName
            binding.productQuantity.text = item.quantity.toString()
            binding.productUnitValue.text = "Valor unitário: ${FormatterUtil.formatToBrazilianCurrency(item.unitValue)}"
            binding.productTotalValue.text = "Valor total: ${FormatterUtil.formatToBrazilianCurrency(item.totalValue)}"

            val product = ProductSale(
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