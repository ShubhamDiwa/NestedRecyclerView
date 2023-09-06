package com.vasyerp.nestedrecyclerview

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
