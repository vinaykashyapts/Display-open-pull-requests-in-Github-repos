package com.vinay.vymoassignment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinay.vymoassignment.data.repositories.RepoPullsRepository

@Suppress("UNCHECKED_CAST")
class PullsViewModelFactory(
    private val repository: RepoPullsRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListRepoDataViewModel(repository) as T
    }

}