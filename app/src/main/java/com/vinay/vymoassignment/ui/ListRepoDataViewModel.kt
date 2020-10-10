package com.vinay.vymoassignment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vinay.vymoassignment.data.models.RepoPulls
import com.vinay.vymoassignment.data.repositories.RepoPullsRepository
import com.vinay.vymoassignment.util.Coroutines
import kotlinx.coroutines.Job

class ListRepoDataViewModel(
    private val repository: RepoPullsRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _pulls = MutableLiveData<List<RepoPulls>>()
    val pulls: LiveData<List<RepoPulls>>
        get() = _pulls

    fun getPulls() {
        job = Coroutines.ioThenMain(
            { repository.getRepoPulls() },
            { _pulls.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}