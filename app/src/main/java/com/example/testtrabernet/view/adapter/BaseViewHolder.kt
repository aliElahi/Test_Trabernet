package com.example.testtrabernet.view.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder <out VB : ViewBinding, T>(protected val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(model: T)

}