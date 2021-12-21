package com.example.testtrabernet.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.testtrabernet.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
) :
    AndroidViewModel(application) {

        fun getUserStateLiveData() = repository.getStateOfUserLiveData()
}