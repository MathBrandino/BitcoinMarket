package com.mathbrandino.bitcoin_market.view.chart.custom

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

object ChartGenerator {

    fun generate(entries: List<Entry>, name: String): LineData {
        val lineDataSet = LineDataSet(entries, name).apply {
            setDrawValues(false)
            lineWidth = 1f
            setDrawCircleHole(false)
            setDrawCircles(false)
        }
        return LineData(lineDataSet).apply {
            isHighlightEnabled = false
        }
    }
}
