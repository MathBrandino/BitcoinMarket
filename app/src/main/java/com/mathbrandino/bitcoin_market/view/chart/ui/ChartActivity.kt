package com.mathbrandino.bitcoin_market.view.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mathbrandino.bitcoin_market.R
import com.mathbrandino.bitcoin_market.view.ViewModelFactory
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

        viewModel.state.observe(this) { Log.i("result", "$it") }
    }

}
