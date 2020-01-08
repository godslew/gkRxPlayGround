package com.godslew.gkrxplayground.di.module

import com.godslew.gkrxplayground.MainActivity
import com.godslew.gkrxplayground.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PresenterModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity() : MainActivity


    @ContributesAndroidInjector
    abstract fun contributeMainFragment() : MainFragment

}