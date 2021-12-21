package com.example.testtrabernet.di

import com.example.testtrabernet.view.adapter.ConsignmentDetailAdapter
import com.example.testtrabernet.view.adapter.ConsignmentListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
object ViewModule {

    @Provides
    fun ConsignmentDetailAdapterProvider() : ConsignmentDetailAdapter{
        return ConsignmentDetailAdapter.create()
    }

    @Provides
    fun ConsignmentListAdapterProvider() : ConsignmentListAdapter{
        return ConsignmentListAdapter.create()
    }
}