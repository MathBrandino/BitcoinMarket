package com.mathbrandino.bitcoin_market.view.chart.mapper

import com.github.mikephil.charting.formatter.ValueFormatter
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset
import org.threeten.bp.format.DateTimeFormatter

object DateTimeFormatter : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        return LocalDateTime.ofEpochSecond(value.toLong(), 0, ZoneOffset.UTC)
            .format(DateTimeFormatter.ofPattern("MMM/YY"))
    }
}

