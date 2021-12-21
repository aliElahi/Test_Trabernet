package com.example.testtrabernet.model.data

import android.content.Context
import com.example.testtrabernet.R
import com.example.testtrabernet.model.utils.ResourceManager

object Utils {

    private fun getListOfMockCity(context: Context) =
        listOf(
            ResourceManager.getString(context.applicationContext, R.string.tehranCity),
            ResourceManager.getString(context.applicationContext, R.string.shirazCity),
            ResourceManager.getString(context.applicationContext, R.string.esfehanCity),
            ResourceManager.getString(context.applicationContext, R.string.mashhadCity),
            ResourceManager.getString(context.applicationContext, R.string.tabrizCity),
            ResourceManager.getString(context.applicationContext, R.string.karajCity),
            ResourceManager.getString(context.applicationContext, R.string.kermanCity)
        )

    private fun getListOfMockWeight(context: Context) =
        listOf(
            ResourceManager.getString(context.applicationContext, R.string.weight1),
            ResourceManager.getString(context.applicationContext, R.string.weight2),
            ResourceManager.getString(context.applicationContext, R.string.weight3),
            ResourceManager.getString(context.applicationContext, R.string.weight4),
            ResourceManager.getString(context.applicationContext, R.string.weight5),
            ResourceManager.getString(context.applicationContext, R.string.weight6),
            ResourceManager.getString(context.applicationContext, R.string.weight7)
        )

    private fun getListOfMockConsignmentType(context: Context) =
        listOf(
            ResourceManager.getString(context.applicationContext, R.string.consignmentPistachio),
            ResourceManager.getString(context.applicationContext, R.string.consignmentApple),
            ResourceManager.getString(context.applicationContext, R.string.consignmentCement),
            ResourceManager.getString(context.applicationContext, R.string.consignmentOrange),
        )

    private fun getListOfMockPrice(context: Context) = listOf(
        ResourceManager.getString(context.applicationContext, R.string.price1),
        ResourceManager.getString(context.applicationContext, R.string.price2),
        ResourceManager.getString(context.applicationContext, R.string.price3),
        ResourceManager.getString(context.applicationContext, R.string.price4),
        ResourceManager.getString(context.applicationContext, R.string.price5),
    )

    private fun <T> getRandomValue(list: List<T>): T {
        return list[(list.indices).random()]
    }

    fun getRandomCity(context: Context): String {
        return getRandomValue(getListOfMockCity(context.applicationContext))
    }

    fun getRandomWeight(context: Context): String {
        return getRandomValue(getListOfMockWeight(context.applicationContext))
    }

    fun getRandomConsignmentType(context: Context): String {
        return getRandomValue(getListOfMockConsignmentType(context.applicationContext))
    }

    fun getRandomPrice(context: Context) : String{
        return getRandomValue(getListOfMockPrice(context))
    }
}
