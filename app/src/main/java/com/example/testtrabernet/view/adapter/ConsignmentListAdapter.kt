package com.example.testtrabernet.view.adapter

import android.view.ViewGroup
import com.example.testtrabernet.databinding.ShowListAdapterLayoutBinding
import com.example.testtrabernet.model.data.ConsignmentDataModel

class ConsignmentListAdapter private constructor() :
    BaseAdapter<ConsignmentDataModel, ConsignmentListViewHolder>() {

    private var listener: ConsignmentListAdapterItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsignmentListViewHolder {
        val layoutInflater = getLayoutInflater(parent.context)
        val binding = ShowListAdapterLayoutBinding.inflate(layoutInflater, parent, false)
        return ConsignmentListViewHolder.create(binding, listener)
    }

    fun setListener(listener: ConsignmentListAdapterItemClickListener) {
        this.listener = listener
    }

    companion object {
        fun create() = ConsignmentListAdapter()
    }
}

class ConsignmentListViewHolder private constructor(
    binding: ShowListAdapterLayoutBinding,
    private val listener: ConsignmentListAdapterItemClickListener?
) :
    BaseViewHolder<ShowListAdapterLayoutBinding, ConsignmentDataModel>(binding) {

    override fun bind(model: ConsignmentDataModel) {

        val textFrom = " از " + model.fromCity
        val textTo = " به " + model.toCity

        binding.textViewFrom.text = textFrom
        binding.textViewTo.text = textTo
        binding.textViewPrice.text = model.price
        binding.textViewWeight.text = model.weight

        binding.root.setOnClickListener {
            listener?.onItemClickListener(model)
        }

    }

    companion object {
        fun create(
            binding: ShowListAdapterLayoutBinding,
            listener: ConsignmentListAdapterItemClickListener?
        ) = ConsignmentListViewHolder(binding , listener)
    }
}

interface ConsignmentListAdapterItemClickListener {

    fun onItemClickListener(model: ConsignmentDataModel)
}