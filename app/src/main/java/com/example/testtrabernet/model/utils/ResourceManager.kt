package com.example.testtrabernet.model.utils

import android.content.Context
import androidx.annotation.StringRes

object ResourceManager {

    fun getString(context: Context , @StringRes id : Int) = context.applicationContext.getString(id)
}