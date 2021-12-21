package com.example.testtrabernet.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.testtrabernet.R
import com.example.testtrabernet.databinding.FragmentShowListBinding
import com.example.testtrabernet.model.data.ConsignmentDataModel
import com.example.testtrabernet.model.data.Status
import com.example.testtrabernet.view.adapter.ConsignmentListAdapter
import com.example.testtrabernet.view.adapter.ConsignmentListAdapterItemClickListener
import com.example.testtrabernet.view.adapter.RecyclerLayoutManagerFactory
import com.example.testtrabernet.view.utils.showToast
import com.example.testtrabernet.viewModel.ShowListFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ShowListFragment : BaseFragment(), ConsignmentListAdapterItemClickListener {

    private var _binding: FragmentShowListBinding? = null
    private val binding get() = _binding

    private val viewModel: ShowListFragmentViewModel by viewModels()

    @Inject
    lateinit var adapter: ConsignmentListAdapter

    override fun initialFields(view: View) {
        adapter.setListener(this)

        binding?.recyclerView?.layoutManager =
            RecyclerLayoutManagerFactory.createVerticalLinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = adapter

        viewModel.getListOfConsignmentLiveData().observe(viewLifecycleOwner) {

            when (it.status) {
                Status.SUCCESS -> {
                    if (it.data != null) {
                        adapter.submitList(it.data)
                    } else {
                        val message = "data must not be null"
                        throw Exception(message)
                    }
                }
                Status.ERROR -> {
                    val message = it.toString()
                    showToast(message)
                }
                else -> {
                    // no need to do something in loading mode
                }
            }

        }

    }

    override fun initialViewBinding(layoutInflater: LayoutInflater, container: ViewGroup?): View? {
        _binding = FragmentShowListBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun clearBinding() {
        _binding = null
    }

    override fun onItemClickListener(model: ConsignmentDataModel) {

        val bundle = Bundle().apply {
            putString(ID, model.id)
        }

        findNavController().navigate(R.id.action_showListFragment_to_showDetailFragment, bundle)
    }

    companion object {
        const val ID = "id"
    }

}