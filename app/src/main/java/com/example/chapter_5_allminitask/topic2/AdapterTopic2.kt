package com.example.chapter_5_allminitask.topic2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_5_allminitask.databinding.ItemContextBinding
import com.example.chapter_5_allminitask.topic2.model.GetAllCarResponseItem

class AdapterTopic2(private val onItemClick: OnClickListener) :
    RecyclerView.Adapter<AdapterTopic2.ViewHolder>() {


    private val diffCallback = object : DiffUtil.ItemCallback<GetAllCarResponseItem>() {
        override fun areItemsTheSame(
            oldItem: GetAllCarResponseItem,
            newItem: GetAllCarResponseItem
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: GetAllCarResponseItem,
            newItem: GetAllCarResponseItem
        ): Boolean = oldItem.hashCode() == newItem.hashCode()

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(value: List<GetAllCarResponseItem>?) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemContextBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }

    override fun getItemCount(): Int = differ.currentList.size


    inner class ViewHolder(private val binding: ItemContextBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: GetAllCarResponseItem) {
            binding.apply {
                tvJudul.text = data.name
                tvPrice.text = data.price.toString()
                root.setOnClickListener{
                    onItemClick.onClickItem(data)
                    //TODO INI TEMPAT CLICK LISTENER
                }

            }
        }
    }

    interface OnClickListener {
        fun onClickItem(data: GetAllCarResponseItem)
        // TODO: INI TEMPAT CLICK LISTENER
    }

}