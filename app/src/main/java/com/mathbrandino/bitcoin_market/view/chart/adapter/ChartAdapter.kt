package com.mathbrandino.bitcoin_market.view.chart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.mathbrandino.bitcoin_market.databinding.ChartItemBinding
import com.mathbrandino.bitcoin_market.view.chart.custom.ChartGenerator
import com.mathbrandino.bitcoin_market.view.chart.custom.DateTimeFormatter
import com.mathbrandino.bitcoin_market.view.chart.model.ChartInformation
import org.threeten.bp.ZoneOffset

class ChartAdapter(private val charts: ArrayList<ChartInformation>) :
    RecyclerView.Adapter<ChartAdapter.ChartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartViewHolder {
        val view =
            ChartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChartViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) =
        holder.bind(charts[position])

    override fun getItemCount(): Int = charts.size

    class ChartViewHolder(private val binding: ChartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chartInformation: ChartInformation) {
            configure(binding.chart)
            binding.chart.data =
                ChartGenerator.generate(convertToListEntry(chartInformation), chartInformation.name)
            binding.chart.animateXY(3000, 3000)
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
