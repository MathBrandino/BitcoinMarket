package com.mathbrandino.bitcoin_market.data.network

import com.mathbrandino.bitcoin_market.data.model.BitcoinChartResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BitcoinService {
    @GET("/charts/{kind}")
    fun fetchChart(@Path("kind") kind: String): Single<BitcoinChartResponse>
}
