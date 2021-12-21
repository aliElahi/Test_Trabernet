package com.example.testtrabernet.view.adapter

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object RecyclerLayoutManagerFactory {

    fun createVerticalLinearLayoutManager(context: Context) : LinearLayoutManager{
        return LinearLayoutManager(context , RecyclerView.VERTICAL , false)
    }
}