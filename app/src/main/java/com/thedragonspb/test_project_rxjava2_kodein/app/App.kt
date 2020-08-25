package com.thedragonspb.test_project_rxjava2_kodein.app

import android.app.Application
import com.thedragonspb.test_project_rxjava2_kodein.app.di.AppInjectionModule
import org.kodein.di.KodeinAware
import org.kodein.di.conf.ConfigurableKodein
import timber.log.Timber
import timber.log.Timber.DebugTree

class App : Application(), KodeinAware {

    override val kodein = ConfigurableKodein()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
        setupDI()
    }

    private fun setupDI() {
        kodein.apply {
            mutable = true

            clear()

            addImport(AppInjectionModule.module)
        }
    }
}