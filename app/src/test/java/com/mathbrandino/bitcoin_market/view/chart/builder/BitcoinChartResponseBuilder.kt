package com.mathbrandino.bitcoin_market.view.chart.builder

import com.mathbrandino.bitcoin_market.data.model.BitcoinChartResponse
import com.mathbrandino.bitcoin_market.data.model.ChartEntry

object BitcoinChartResponseBuilder {
    fun build(
        status: String = "ok",
        name: String = "Market Price",
        period: String = "Day",
        description: String = "Some Description",
        entries: ArrayList<ChartEntry> = arrayListOf(
            ChartEntry(timestamp = 1573257600, value = 8766.04)
        )
    ): BitcoinChartResponse = BitcoinChartResponse(
        status = status,
        name = name,
        period = period,
        description = description,
        entries = entries
    )
}
