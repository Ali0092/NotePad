package com.example.notepad.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notepad.Fragments.MainFragment
import com.example.notepad.Fragments.MainFragmentDirections
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
            this.titleEt.setText(items[position].title.toString())
            this.bodyEt.setText(items[position].body.toString())
        }
        holder.binding.itemLayout.setOnClickListener {
            val action=MainFragmentDirections.actionMainFragmentToUpdateFragment(items[position])
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getDataChanges(items: List<Item>){
        this.items=items
        this.notifyDataSetChanged()
    }

}