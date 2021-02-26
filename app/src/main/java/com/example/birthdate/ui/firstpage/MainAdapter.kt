package com.example.birthdate.ui.firstpage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.birthdate.databinding.ItemShowInfoBinding
import com.example.birthdate.datamodel.MainTableModel

class MainAdapter(val context: Context, val showProductListener: showProductListener) :
    ListAdapter<MainTableModel, MainAdapter.MainViewHolder>(ViewPagerDiffCallback()) {

    class MainViewHolder(val binding: ItemShowInfoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemShowInfoBinding.inflate(LayoutInflater.from(context), parent, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = currentList[position]
        holder.binding.data = item

        holder.binding.btnShowList.setOnClickListener {
            showProductListener.showClick(item)
        }
        holder.binding.btnDelete.setOnLongClickListener {
            showProductListener.deleteClick(item)
            return@setOnLongClickListener true
        }
    }
}

class ViewPagerDiffCallback : DiffUtil.ItemCallback<MainTableModel>() {
    override fun areItemsTheSame(oldItem: MainTableModel, newItem: MainTableModel): Boolean {
        return newItem.id == oldItem.id
    }

    override fun areContentsTheSame(oldItem: MainTableModel, newItem: MainTableModel): Boolean {
        return newItem == oldItem
    }
}

interface showProductListener {
    fun showClick(item: MainTableModel)
    fun deleteClick(item: MainTableModel)
}
