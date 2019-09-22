package br.com.dojo.project.application

import android.app.Application
import br.com.dojo.project.koin.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            // Android context
            androidContext(this@CustomApplication)
            // modules
            modules(serviceModule)
            modules(repositoryModule)
            modules(interactorModule)
            modules(chooseParamsModule)
            modules(nameListModule)
        }
    }
}