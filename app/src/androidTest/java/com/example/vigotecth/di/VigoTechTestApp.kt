package com.example.vigotecth.di

import com.example.vigotecth.VigoTechApp

class VigoTechTestApp: VigoTechApp() {

    override fun createComponent(): AppComponent =
        DaggerTestAppComponent
            .builder()
            .application(this)
            .build()
}