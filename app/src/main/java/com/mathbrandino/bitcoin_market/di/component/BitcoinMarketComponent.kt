package com.mathbrandino.bitcoin_market.di.component

import com.mathbrandino.bitcoin_market.app.BitcoinMarketApplication
import com.mathbrandino.bitcoin_market.di.module.ActivitiesModule
import com.mathbrandino.bitcoin_market.di.module.FragmentsModule
import com.mathbrandino.bitcoin_market.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, NetworkModule::class, ActivitiesModule::class, FragmentsModule::class])
interface BitcoinMarketComponent {
    fun inject(app: BitcoinMarketApplication)
}
