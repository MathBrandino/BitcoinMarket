package com.mathbrandino.bitcoin_market.di.component

import com.mathbrandino.bitcoin_market.app.BitcoinMarketApplication
import com.mathbrandino.bitcoin_market.di.module.ActivitiesModule
import com.mathbrandino.bitcoin_market.di.module.FragmentsModule
import com.mathbrandino.bitcoin_market.di.module.NetworkModule
import com.mathbrandino.bitcoin_market.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        ActivitiesModule::class,
        FragmentsModule::class
    ]
)
interface BitcoinMarketComponent {
    fun inject(app: BitcoinMarketApplication)
}
