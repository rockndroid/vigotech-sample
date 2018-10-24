package com.example.vigotecth.di

import com.example.vigotecth.ui.groups_list.GroupsListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector()
    abstract fun bindGroupsListActivity(): GroupsListActivity
}