package br.com.filazero

import android.app.Application
import br.com.filazero.di.module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FilaZeroApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@FilaZeroApplication)
            modules(listOf(module))
        }
    }
}