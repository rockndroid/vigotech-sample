package com.example.vigotecth.ui.groups_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vigotecth.data.model.Group
import com.example.vigotecth.data.remote.VigoTechApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class GroupListViewModel
    constructor(private val api: VigoTechApi): ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val groupsLiveData = MutableLiveData<List<Group>>()

    fun onGroupsReady(): LiveData<List<Group>> = groupsLiveData

    init {
        compositeDisposable.add(
            requestGroups().subscribeBy { groupsList ->
                groupsLiveData.value = groupsList
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    private fun requestGroups() =
        api.groups()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}