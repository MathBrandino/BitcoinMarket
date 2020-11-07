package com.mathbrandino.bitcoin_market.di.module

import com.mathbrandino.bitcoin_market.data.network.BitcoinService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.blockchain.info")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()


    @Provides
    @Singleton
    fun getBitcoinService(retrofit: Retrofit): BitcoinService =
        retrofit.create(BitcoinService::class.java)
}
