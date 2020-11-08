package com.mathbrandino.bitcoin_market.view.chart.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.mathbrandino.bitcoin_market.R
import com.mathbrandino.bitcoin_market.view.chart.custom.ChartGenerator
import com.mathbrandino.bitcoin_market.view.chart.custom.DateTimeFormatter
import com.mathbrandino.bitcoin_market.view.chart.model.ChartInformation
import org.threeten.bp.ZoneOffset

class ChartAdapter(private val charts: ArrayList<ChartInformation>) :
    RecyclerView.Adapter<ChartAdapter.ChartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.chart_item, parent, false)
        return ChartViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) =
        holder.bind(charts[position])

    override fun getItemCount(): Int = charts.size

    class ChartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(chart: ChartInformation) {
            val chartView = itemView.findViewById<LineChart>(R.id.chart)
            configure(chartView)
            chartView.data = ChartGenerator.generate(convertToListEntry(chart), chart.name)
            chartView.animateXY(3000, 3000)
        }

        private fun convertToListEntry(chart: ChartInformation): List<Entry> = chart.entries.map {
            Entry(
                it.moment.toEpochSecond(ZoneOffset.UTC).toFloat(),
                it.amount.toFloat()
            )
        }

        private fun configure(chartView: LineChart) {
            val xAxis = chartView.xAxis
            xAxis.setDrawGridLines(false)
            xAxis.valueFormatter = DateTimeFormatter
            chartView.setScaleEnabled(false)
            chartView.axisRight.isEnabled = false
            chartView.description.isEnabled = false
        }
    }
}
