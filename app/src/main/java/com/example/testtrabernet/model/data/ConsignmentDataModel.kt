package com.example.testtrabernet.model.data

import android.content.Context
import com.example.testtrabernet.R
import com.example.testtrabernet.model.utils.ResourceManager
import java.util.*
import kotlin.collections.ArrayList

data class ConsignmentDataModel(
    val id: String,
    val fromCity: String,
    val toCity: String,
    val weight: String,
    val consignmentType: String,
    val packingType: String,
    val loadDateTime: Date ,
    val price : String
) {

    fun getListOfNameValue(context: Context) = ArrayList<NameValue>().apply {

        add(NameValue(ResourceManager.getString(context.applicationContext , R.string.source) , fromCity))
        add(NameValue(ResourceManager.getString(context.applicationContext , R.string.destination) , toCity))
        add(NameValue(ResourceManager.getString(context.applicationContext , R.string.Weight) , weight))
        add(NameValue(ResourceManager.getString(context.applicationContext , R.string.consignment) , consignmentType))
        add(NameValue(ResourceManager.getString(context.applicationContext , R.string.packing) , packingType))
        add(NameValue(ResourceManager.getString(context.applicationContext , R.string.date), loadDateTime.toString()))
    }


    companion object {

        fun getMockListOfConsignmentDataModel(context: Context) =
            ArrayList<ConsignmentDataModel>().apply {
                for (i in 0..6) {
                    add(createMockModel(context.applicationContext))
                }
            }

        private fun createMockModel(context: Context): ConsignmentDataModel {
            return ConsignmentDataModel(
                id = UUID.randomUUID().toString(),
                fromCity = Utils.getRandomCity(context.applicationContext),
                toCity = Utils.getRandomCity(context.applicationContext),
                weight = Utils.getRandomWeight(context.applicationContext),
                consignmentType = Utils.getRandomConsignmentType(context.applicationContext),
                packingType = ResourceManager.getString(
                    context.applicationContext,
                    R.string.packingMod
                ),
                loadDateTime = Date(System.currentTimeMillis()) ,
                price = Utils.getRandomPrice(context.applicationContext)
            )
        }
    }
}