package com.example.testtrabernet.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initialViewBinding(layoutInflater,container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialFields(view)
    }

    abstract fun initialFields(view: View)

    abstract fun initialViewBinding(layoutInflater: LayoutInflater, container: ViewGroup?) : View?

    abstract fun clearBinding()

    override fun onDestroyView() {
        super.onDestroyView()
        clearBinding()
    }
}