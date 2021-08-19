package com.example.moviesproject

import android.app.Application
import android.content.Context
import com.example.moviesproject.di.ApiModuleKoin
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MoviesApplication)
            modules(ApiModuleKoin.modules)
        }
    }
}