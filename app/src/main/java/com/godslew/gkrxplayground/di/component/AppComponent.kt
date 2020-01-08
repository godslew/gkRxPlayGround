package com.godslew.gkrxplayground.di.component

import com.godslew.gkrxplayground.App
import com.godslew.gkrxplayground.di.module.AppModule
import com.godslew.gkrxplayground.di.module.PresenterModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [AndroidInjectionModule::class,
        AppModule::class,
        PresenterModule::class]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }
}