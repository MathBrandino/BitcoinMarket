package com.mathbrandino.bitcoin_market.data.model

import com.google.gson.annotations.SerializedName

data class BitcoinChartResponse(
    @SerializedName("status") val status: String,
    @SerializedName("name") val name: String,
    @SerializedName("period") val period: String,
    @SerializedName("description") val description: String,
    @SerializedName("values") val entries: List<ChartEntry>
)


data class ChartEntry(
    @SerializedName("x") val timestamp: Long,
    @SerializedName("y") val value: Double,
)
