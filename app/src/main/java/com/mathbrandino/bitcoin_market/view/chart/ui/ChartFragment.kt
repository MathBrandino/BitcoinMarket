package com.mathbrandino.bitcoin_market.view.chart.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.mathbrandino.bitcoin_market.R
import com.mathbrandino.bitcoin_market.view.chart.adapter.ChartAdapter
import com.mathbrandino.bitcoin_market.view.chart.model.ChartInformation

class ChartFragment : Fragment() {

    @Suppress("UNCHECKED_CAST")
    private val charts: ArrayList<ChartInformation>
        get() = arguments?.getSerializable(EXTRA_INFORMATION) as ArrayList<ChartInformation>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.chart_fragment, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.chart_list)
        recyclerView.adapter = ChartAdapter(charts = charts)

        return view
    }

    companion object {
        private const val EXTRA_INFORMATION = "EXTRA_INFORMATION";

        operator fun invoke(charts: ArrayList<ChartInformation>): ChartFragment {
            val bundle = Bundle()
            bundle.putSerializable(EXTRA_INFORMATION, charts)
            return ChartFragment().apply { arguments = bundle }
        }
    }
}
