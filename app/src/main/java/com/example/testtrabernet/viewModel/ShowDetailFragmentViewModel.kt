package com.example.testtrabernet.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testtrabernet.model.data.ConsignmentDataModel
import com.example.testtrabernet.model.data.Resource
import com.example.testtrabernet.model.data.Status
import com.example.testtrabernet.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowDetailFragmentViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
) :
    AndroidViewModel(application) {

    private val mutableLiveDataConsignment = MutableLiveData<Resource<ConsignmentDataModel>>()

    fun getConsignmentById(id: String) {
        mutableLiveDataConsignment.postValue(Resource.loading())

        val response = repository.getConsignmentById(id)

        when (response.status) {

            Status.LOADING -> {
                mutableLiveDataConsignment.postValue(Resource.loading())
            }
            Status.SUCCESS -> {
                mutableLiveDataConsignment.postValue(response)
            }
            Status.ERROR -> {
                mutableLiveDataConsignment.postValue(Resource.error(response.message))
            }
        }
    }

    fun getConsignmentLiveData(): LiveData<Resource<ConsignmentDataModel>> =
        mutableLiveDataConsignment

    fun acceptConsignment(id: String) {

        viewModelScope.launch(IO) {

            val lastData = mutableLiveDataConsignment.value

            mutableLiveDataConsignment.postValue(Resource.loading())

            val response = repository.acceptConsignment(id)

            when (response.status) {

                Status.SUCCESS -> {
                    val message = "accept"
                    mutableLiveDataConsignment.postValue(lastData?.copy(message = message))
                }
                Status.ERROR -> {
                    val message = response.message.toString()
                    mutableLiveDataConsignment.postValue(Resource.error(message))
                }
                Status.LOADING -> {
                    mutableLiveDataConsignment.postValue(Resource.loading())
                }
            }

        }
    }
}