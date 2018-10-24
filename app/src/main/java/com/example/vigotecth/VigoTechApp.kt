package com.example.vigotecth

import android.app.Activity
import android.app.Application
import com.example.vigotecth.di.AppComponent
import com.example.vigotecth.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class VigoTechApp : Application(), HasActivityInjector {
    private lateinit var appComponent: AppComponent

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        appComponent = createComponent()
            .also { it.inject(this) }
    }

    open fun createComponent(): AppComponent =
        DaggerAppComponent.builder()
            .application(this)
            .build()

    fun component() = appComponent

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}