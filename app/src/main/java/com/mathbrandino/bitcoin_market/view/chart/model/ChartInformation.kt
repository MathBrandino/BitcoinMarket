package com.mathbrandino.bitcoin_market.view.chart.model

import org.threeten.bp.LocalDateTime
import java.io.Serializable
import java.math.BigDecimal

data class ChartInformation(
    val name: String,
    val description: String,
    val entries: ArrayList<Entry>
) : Serializable

data class Entry(
    val moment: LocalDateTime,
    val amount: BigDecimal
) : Serializable
