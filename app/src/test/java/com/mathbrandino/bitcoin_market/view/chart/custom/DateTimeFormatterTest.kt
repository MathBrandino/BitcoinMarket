package com.mathbrandino.bitcoin_market.view.chart.custom

import org.junit.Test
import org.junit.Assert.assertEquals

class DateTimeFormatterTest {
    @Test
    fun `should convert timestamp to right string pattern`() {
        val oct2020 = DateTimeFormatter.getFormattedValue(1604102400F)
        assertEquals("Oct/20", oct2020)
    }
}