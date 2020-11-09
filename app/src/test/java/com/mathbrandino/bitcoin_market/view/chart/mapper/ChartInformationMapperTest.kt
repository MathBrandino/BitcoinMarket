package com.mathbrandino.bitcoin_market.view.chart.mapper

import com.mathbrandino.bitcoin_market.data.model.BitcoinChartResponse
import com.mathbrandino.bitcoin_market.data.model.ChartEntry
import com.mathbrandino.bitcoin_market.view.chart.builder.ChartInformationBuilder
import org.junit.Assert
import org.junit.Test

class ChartInformationMapperTest {

    @Test
    fun `should map the api response to business object`() {
        val mapperResult = ChartInformationMapper.map(
            BitcoinChartResponse(
                status = "ok",
                name = "Market Price",
                period = "Day",
                description = "Some Description",
                entries = arrayListOf(
                    ChartEntry(timestamp = 1573257600, value = 8766.04)
                )
            )
        )
        Assert.assertEquals(ChartInformationBuilder.build(), mapperResult)
    }
}
