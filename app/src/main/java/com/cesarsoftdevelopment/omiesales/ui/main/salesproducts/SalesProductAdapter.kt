package com.cesarsoftdevelopment.omiesales.ui.main.salesproducts

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cesarsoftdevelopment.omiesales.databinding.SaleProductItemBinding
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.utils.FormatterUtil

class SalesProductAdapter : ListAdapter<Product, SalesProductAdapter.ViewHolder>(
    SalesProductDiffCallback()
)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class SalesProductDiffCallback : DiffUtil.ItemCallback<Product>() {

        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder private constructor(
        private val binding: SaleProductItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item : Product) {
            binding.productName.text = item.productName
            binding.productQuantity.text = "Qtde produtos: ${item.quantity}"
            binding.productUnitValue.text = "Valor unitário: ${FormatterUtil.formatToBrazilianCurrency(item.unitValue)}"
            binding.productUnitValue.text = "Valor total: ${FormatterUtil.formatToBrazilianCurrency(item.totalValue)}"
        }

        companion object {

            fun from(parent: ViewGroup): ViewHolder {

                val binding = SaleProductItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

                return ViewHolder(
                    binding
                )
            }
        }
    }

}