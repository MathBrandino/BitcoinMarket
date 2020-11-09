package com.mathbrandino.bitcoin_market.view.chart.mapper

import com.mathbrandino.bitcoin_market.data.model.BitcoinChartResponse
import com.mathbrandino.bitcoin_market.data.model.ChartEntry
import com.mathbrandino.bitcoin_market.view.chart.model.ChartInformation
import com.mathbrandino.bitcoin_market.view.chart.model.Entry
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset
import java.math.BigDecimal

object ChartInformationMapper {
    fun map(chartResponse: BitcoinChartResponse): ChartInformation {
        return ChartInformation(
            name = chartResponse.name,
            description = chartResponse.description,
            entries = chartResponse.entries.map { map(it) } as ArrayList<Entry>
        )
    }

    private fun map(chartEntry: ChartEntry): Entry {
        return Entry(
            moment = LocalDateTime.ofEpochSecond(chartEntry.timestamp, 0, ZoneOffset.UTC),
            amount = BigDecimal(chartEntry.value)
        )
    }
}
