package com.example.vigotecth.di

import android.app.Application
import android.content.Context
import com.example.vigotecth.data.remote.VigoTechApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}