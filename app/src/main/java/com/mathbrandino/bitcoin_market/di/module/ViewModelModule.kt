package com.mathbrandino.bitcoin_market.di.module

import androidx.lifecycle.ViewModelProvider
import com.mathbrandino.bitcoin_market.view.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
