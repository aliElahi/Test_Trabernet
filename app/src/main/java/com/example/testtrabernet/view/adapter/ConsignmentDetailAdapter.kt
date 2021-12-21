package com.example.testtrabernet.view.adapter

import android.view.ViewGroup
import com.example.testtrabernet.databinding.ShowDetailAdapterLayoutBinding
import com.example.testtrabernet.model.data.NameValue

class ConsignmentDetailAdapter private constructor() :
    BaseAdapter<NameValue, ConsignmentDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsignmentDetailViewHolder {
        val layoutInflater = getLayoutInflater(parent.context)
        val binding = ShowDetailAdapterLayoutBinding.inflate(layoutInflater, parent, false)
        return ConsignmentDetailViewHolder.create(binding)
    }

    companion object{
        fun create() = ConsignmentDetailAdapter()
    }
}

class ConsignmentDetailViewHolder private constructor(binding: ShowDetailAdapterLayoutBinding) :
    BaseViewHolder<ShowDetailAdapterLayoutBinding, NameValue>(binding) {

    override fun bind(model: NameValue) {

        binding.textViewName.text = model.name
        binding.textViewValue.text = model.value

    }

    companion object {
        fun create(binding: ShowDetailAdapterLayoutBinding) = ConsignmentDetailViewHolder(binding)
    }
}