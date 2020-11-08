package com.mathbrandino.bitcoin_market.data.repository

import com.mathbrandino.bitcoin_market.data.model.BitcoinChartResponse
import com.mathbrandino.bitcoin_market.data.network.BitcoinService
import io.reactivex.Single
import javax.inject.Inject

class ChartRepository @Inject constructor(private val api: BitcoinService) {

    fun fetchCharts(): Single<List<BitcoinChartResponse>> =
        Single.zip(
            api.fetchChart("market-price"),
            api.fetchChart("transactions-per-second"),
            api.fetchChart("trade-volume"),
            { t1, t2, t3 -> arrayListOf(t1, t2, t3) })
}
