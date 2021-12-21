package com.example.testtrabernet.view.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.testtrabernet.databinding.FragmentShowDetailBinding
import com.example.testtrabernet.model.data.Status
import com.example.testtrabernet.view.adapter.ConsignmentDetailAdapter
import com.example.testtrabernet.view.adapter.RecyclerLayoutManagerFactory
import com.example.testtrabernet.view.utils.showToast
import com.example.testtrabernet.viewModel.ShowDetailFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ShowDetailFragment : BaseFragment(), View.OnClickListener {

    private var _binding: FragmentShowDetailBinding? = null
    private val binding get() = _binding

    private val viewModel: ShowDetailFragmentViewModel by viewModels()

    @Inject
    lateinit var adapter: ConsignmentDetailAdapter

    override fun initialFields(view: View) {

        binding?.button?.setOnClickListener(this)

        binding?.recyclerView?.layoutManager =
            RecyclerLayoutManagerFactory.createVerticalLinearLayoutManager(requireContext())

        binding?.recyclerView?.adapter = adapter

        viewModel.getConsignmentLiveData().observe(viewLifecycleOwner) {

            when (it.status) {
                Status.LOADING -> {
                    showProgressBar()
                }
                Status.SUCCESS -> {
                    hideProgressBar()

                    val listOfData =
                        it.data?.getListOfNameValue(requireContext().applicationContext)
                    adapter.submitList(listOfData)

                    val buttonText = " با " + it.data?.price + " کرایه می برم. "
                    binding?.button?.text = buttonText

                    if(it.message != null)
                        showToast(it.message)
                }
                Status.ERROR -> {
                    showToast(it.message.toString())
                    hideProgressBar()
                }
            }
        }

        viewModel.getConsignmentById(getConsignmentId().toString())


    }

    override fun initialViewBinding(layoutInflater: LayoutInflater, container: ViewGroup?): View? {
        _binding = FragmentShowDetailBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun clearBinding() {
        _binding = null
    }

    private fun showProgressBar() {
        binding?.progressBar?.isVisible = true
    }

    private fun hideProgressBar() {
        binding?.progressBar?.isVisible = false
    }

    private fun getConsignmentId() = arguments?.getString(ShowListFragment.ID)

    override fun onClick(v: View?) {
        viewModel.acceptConsignment(getConsignmentId().toString())
    }
}