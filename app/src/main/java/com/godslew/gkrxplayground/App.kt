package com.godslew.gkrxplayground

import com.godslew.gkrxplayground.di.component.DaggerAppComponent
import com.godslew.gkrxplayground.di.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}