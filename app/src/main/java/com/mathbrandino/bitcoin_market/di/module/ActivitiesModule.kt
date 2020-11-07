package com.mathbrandino.bitcoin_market.di.module

import com.mathbrandino.bitcoin_market.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector
    abstract fun contributeActivityAndroidInjector(): MainActivity

}
