package com.example.vigotecth

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.example.vigotecth.di.VigoTechTestApp

class VigoTechTestRunner: AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, VigoTechTestApp::class.java.name, context)
    }
}