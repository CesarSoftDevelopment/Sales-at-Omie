package com.cesarsoftdevelopment.omiesales.ui.main.saleshistory

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.databinding.SaleItemBinding
import com.cesarsoftdevelopment.omiesales.domain.model.Product

class SalesHistoryAdapter(
    private val onClickListener: OnClickListener
) : ListAdapter<Sale, SalesHistoryAdapter.ViewHolder>(SalesHistoryDiffCallback()) {

    class OnClickListener(val clickListener: (products: List<Product>) -> Unit) {
        fun onClick(products: List<Product>) = clickListener(products)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val sales = getItem(position)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(sales.products)
        }

        holder.bind(sales)
    }

    class SalesHistoryDiffCallback : DiffUtil.ItemCallback<Sale>() {

        override fun areItemsTheSame(oldItem: Sale, newItem: Sale): Boolean {
            return oldItem.saleId == newItem.saleId
        }

        override fun areContentsTheSame(oldItem: Sale, newItem: Sale): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder private constructor(
        private val binding: SaleItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item : Sale) {
            binding.orderNumber.text = "Número do pedido: ${item.saleId}"
            binding.clientName.text = "Cliente: ${item.clientName}"

        }

        companion object {

            fun from(parent: ViewGroup): ViewHolder {

                val binding = SaleItemBinding.inflate(
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