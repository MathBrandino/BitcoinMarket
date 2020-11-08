package com.mathbrandino.bitcoin_market.di.module

import com.mathbrandino.bitcoin_market.view.chart.ui.ChartActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector
    abstract fun contributeActivityAndroidInjector(): ChartActivity
}
