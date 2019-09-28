package com.example.vigotecth.ui.groups_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vigotecth.data.remote.VigoTechApi
import javax.inject.Inject

class GroupListViewModelFactory
    @Inject constructor(
        val api: VigoTechApi
    ) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return GroupListViewModel(api) as T
    }
}