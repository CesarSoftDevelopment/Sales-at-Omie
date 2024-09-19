package com.cesarsoftdevelopment.omiesales.ui.main.makesale

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cesarsoftdevelopment.omiesales.databinding.ProductItemBinding
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import com.cesarsoftdevelopment.omiesales.utils.FormatterUtil

class MakeSaleAdapter(
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
        return ViewHolder.from(parent, makeSaleViewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
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


            binding.ibTrash.setOnClickListener {
                makeSaleViewModel.deleteProduct(item.id)
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