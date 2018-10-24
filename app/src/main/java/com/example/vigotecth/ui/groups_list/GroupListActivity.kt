package com.example.vigotecth.ui.groups_list

import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vigotecth.R
import com.example.vigotecth.databinding.ActivityGroupsBinding
import dagger.android.AndroidInjection
import javax.inject.Inject
import android.util.DisplayMetrics
import com.example.vigotecth.ui.utils.SpacesItemDecoration

class GroupsListActivity : AppCompatActivity() {

    @Inject lateinit var groupListViewModelFactory: GroupListViewModelFactory

    private lateinit var groupsAdapter : GroupListAdapter

    private val recyclerItemPadding by lazy {
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, DisplayMetrics()).toInt()
    }

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
            addItemDecoration(SpacesItemDecoration(recyclerItemPadding))
        }
    }

    private fun initSubscribers(viewModel: GroupListViewModel) {
        viewModel.onGroupsReady().observe(this, Observer { groups ->
            groupsAdapter.submitGroups(groups)
        })
    }
}
