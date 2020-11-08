package com.mathbrandino.bitcoin_market.app

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.mathbrandino.bitcoin_market.di.component.DaggerBitcoinMarketComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BitcoinMarketApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>


    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        DaggerBitcoinMarketComponent.create().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
