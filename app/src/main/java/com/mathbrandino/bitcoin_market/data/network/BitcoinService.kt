package com.mathbrandino.bitcoin_market.data.network

import com.mathbrandino.bitcoin_market.data.model.BitcoinChartResponse
import io.reactivex.Single
import retrofit2.http.GET

interface BitcoinService {
    @GET("/charts/market-price")
    fun fetchChart(): Single<BitcoinChartResponse>
}
