package com.example.vigotecth.ui.groups_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vigotecth.R
import com.example.vigotecth.databinding.ActivityGroupsBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class GroupsListActivity : AppCompatActivity() {

    @Inject lateinit var groupListViewModelFactory: GroupListViewModelFactory

    private lateinit var groupsAdapter : GroupListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityGroupsBinding>(this, R.layout.activity_groups)
            .also { setupRecycler(it) }

        AndroidInjection.inject(this)

        ViewModelProviders.of(this, groupListViewModelFactory)
            .get(GroupListViewModel::class.java)
            .also { initSubscribers(it) }
    }

    private fun setupRecycler(it: ActivityGroupsBinding) {
        with(it.recyclerGroups) {
            adapter = GroupListAdapter().also { groupsAdapter= it}
            layoutManager = GridLayoutManager(this@GroupsListActivity, 2)
        }
    }

    private fun initSubscribers(viewModel: GroupListViewModel) {
        viewModel.onGroupsReady().observe(this, Observer { groups ->
            groupsAdapter.submitGroups(groups)
        })
    }
}
