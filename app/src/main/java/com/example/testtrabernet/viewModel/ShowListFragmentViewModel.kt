package com.example.testtrabernet.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtrabernet.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowListFragmentViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
) :
    AndroidViewModel(application) {

    fun getListOfConsignmentLiveData ()  = repository.getListOfConsignment()



}