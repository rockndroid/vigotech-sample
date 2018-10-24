package com.example.vigotecth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.vigotecth.ui.vm.GroupListViewModel
import com.example.vigotecth.ui.vm.GroupListViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var groupListViewModelFactory: GroupListViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        ViewModelProviders.of(this, groupListViewModelFactory)
            .get(GroupListViewModel::class.java)
            .also { initSubscribers(it) }
    }

    private fun initSubscribers(viewModel: GroupListViewModel) {
        viewModel.onGroupsReady().observe(this, Observer { groups ->
            groups.forEach { group -> println("Group -> $group") }
        })
    }
}
