package com.example.notepad.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notepad.Fragments.MainFragment
import com.example.notepad.R
import com.example.notepad.databinding.FragmentMainBinding
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
        holder.binding.itemLayout.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_updateFragment)
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