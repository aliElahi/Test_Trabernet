package com.example.testtrabernet.model.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testtrabernet.model.data.ConsignmentDataModel
import com.example.testtrabernet.model.data.Resource
import com.example.testtrabernet.model.data.Status
import kotlinx.coroutines.delay

class RepositoryImp(context: Context) : Repository {

    private val list = ConsignmentDataModel.getMockListOfConsignmentDataModel(context.applicationContext)

    private val stateOfAcceptUser = MutableLiveData<Resource<Boolean>>()
    private val mutableLiveDataListOfConsignment = MutableLiveData<Resource<List<ConsignmentDataModel>>>().apply {
            postValue(Resource.success(list))
        }

    override fun getStateOfUserLiveData(): LiveData<Resource<Boolean>> {
        return stateOfAcceptUser
    }

    override suspend fun acceptConsignment(id: String): Resource<Boolean> {

        val state = stateOfAcceptUser.value

        if (state?.status == Status.SUCCESS) {
            if (state.data == true) {
                val message = "you can't accept now"
                return Resource.error(message)
            }
        }

        stateOfAcceptUser.postValue(Resource.loading())
        delay(700)

        val item = list.find { it.id == id }

        if (item == null) {
            val message = "id is not valid"
            return Resource.error(message)
        }

        stateOfAcceptUser.postValue(Resource.success(true))
        return Resource.success(true)

    }

    override fun getListOfConsignment(): LiveData<Resource<List<ConsignmentDataModel>>> {
        return mutableLiveDataListOfConsignment
    }

    override fun getConsignmentById(id: String) : Resource<ConsignmentDataModel>{
        val model =  mutableLiveDataListOfConsignment.value?.data?.find { id == it.id }

        if(model == null){
            val message = "id is invalid"
            return Resource.error(message)
        }

        return Resource.success(model)
    }


}