package com.ringov.tnknws

import android.app.Application
import android.os.StrictMode
import com.ringov.tnknws.dagger.AppComponent
import com.ringov.tnknws.dagger.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary

class App : Application() {

    companion object {
        lateinit var component: AppComponent
            private set
    }


    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)
        initStrictMode()

        initDependencies()
        Logger.d("App created")
    }


    private fun initDependencies() {
        component = DaggerAppComponent
            .builder()
            .build()
    }

    private fun initStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDropBox()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDropBox()
                    .build()
            )
        }
    }

}