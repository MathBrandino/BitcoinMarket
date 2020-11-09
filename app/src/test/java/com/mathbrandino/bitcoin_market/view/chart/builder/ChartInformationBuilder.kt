package com.mathbrandino.bitcoin_market.view.chart.builder

import com.mathbrandino.bitcoin_market.view.chart.model.ChartInformation
import com.mathbrandino.bitcoin_market.view.chart.model.Entry
import org.threeten.bp.LocalDateTime
import org.threeten.bp.Month
import java.math.BigDecimal

object ChartInformationBuilder {

    fun build(
        name: String = "Market Price",
        description: String = "Some Description",
        entries: ArrayList<Entry> = arrayListOf(
            Entry(
                LocalDateTime.of(
                    2019,
                    Month.NOVEMBER,
                    9,
                    0,
                    0,
                    0,
                    0
                ),
                BigDecimal(8766.04)
            )
        )
    ): ChartInformation {
        return ChartInformation(name, description, entries)
    }

}
