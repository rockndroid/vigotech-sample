package com.example.vigotecth.di

import android.app.Application
import com.example.vigotecth.VigoTechApp
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
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(vigoTechApp: VigoTechApp)
}