package com.mathbrandino.bitcoin_market.view.chart.model

sealed class ChartInformationState {
    object Loading : ChartInformationState()
    data class Loaded(val charts: ArrayList<ChartInformation>) : ChartInformationState()
    data class Error(val error: String) : ChartInformationState()
}