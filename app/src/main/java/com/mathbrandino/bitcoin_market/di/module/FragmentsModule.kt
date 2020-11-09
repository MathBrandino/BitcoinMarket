package com.mathbrandino.bitcoin_market.di.module

import com.mathbrandino.bitcoin_market.view.chart.ui.ErrorFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {
    @ContributesAndroidInjector
    abstract fun contributeFragmentAndroidInjector(): ErrorFragment
}
