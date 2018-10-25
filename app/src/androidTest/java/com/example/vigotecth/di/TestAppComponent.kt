package com.example.vigotecth.di

import android.app.Application
import com.example.vigotecth.ui.groups_list.LauncherActivityTestWithIdling
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(modules = [
    AppModule::class,
    AndroidInjectionModule::class,
    ActivityModule::class,
    ApiModule::class
])
@Singleton
interface TestAppComponent: AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(groupsTest: LauncherActivityTestWithIdling)
}