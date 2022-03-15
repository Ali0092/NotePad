package com.example.notepad.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notepad.databinding.ItemLayoutBinding
import com.example.notepad.model.Item

class ItemAdapter:RecyclerView.Adapter<ItemAdapter.viewHolder>() {

    var items= emptyList<Item>()

    inner class viewHolder(val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))
    }


    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.binding.apply {
            this.titleEt.text=items[position].title
            this.bodyEt.text=items[position].body
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getDataChanges(items: List<Item>){
        this.items=items
        this.notifyDataSetChanged()
    }

}