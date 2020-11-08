package com.mathbrandino.bitcoin_market.view.chart.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mathbrandino.bitcoin_market.R
import com.mathbrandino.bitcoin_market.view.ViewModelFactory
import com.mathbrandino.bitcoin_market.view.chart.model.ChartInformationState
import com.mathbrandino.bitcoin_market.view.chart.viewmodel.ChartViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class ChartActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        val viewModel = ViewModelProvider(this, factory)[ChartViewModel::class.java]

        viewModel.fetchChart()

        viewModel.state.observe(this) {
            val fragment = when (it) {
                ChartInformationState.Loading -> LoadingFragment()
                is ChartInformationState.Loaded -> ChartFragment.create(it.charts)
                else -> Fragment()
            }
            show(fragment)
        }
    }

    private fun show(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.chart_frame, fragment).commit()
    }

}
