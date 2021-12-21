package com.example.testtrabernet.view.adapter

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T, VH : BaseViewHolder<ViewBinding, T>> :

    ListAdapter<T, VH>(object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }
    }) {

    override fun onBindViewHolder(holder: VH, position: Int) {
        val model = getItem(holder.adapterPosition)
        holder.bind(model)
    }

    protected fun getLayoutInflater(context: Context): LayoutInflater = LayoutInflater.from(context)
}