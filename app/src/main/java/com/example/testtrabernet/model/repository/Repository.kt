package com.example.testtrabernet.model.repository

import androidx.lifecycle.LiveData
import com.example.testtrabernet.model.data.ConsignmentDataModel
import com.example.testtrabernet.model.data.Resource

interface Repository {

    fun getStateOfUserLiveData() : LiveData<Resource<Boolean>>

    suspend fun acceptConsignment(id : String) : Resource<Boolean>

    fun getListOfConsignment() : LiveData<Resource<List<ConsignmentDataModel>>>

    fun getConsignmentById(id : String) : Resource<ConsignmentDataModel>
}