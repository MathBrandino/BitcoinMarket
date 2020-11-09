package com.mathbrandino.bitcoin_market.view.chart.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jakewharton.rxbinding4.view.clicks
import com.mathbrandino.bitcoin_market.databinding.ErrorFragmentBinding
import com.mathbrandino.bitcoin_market.view.ViewModelFactory
import com.mathbrandino.bitcoin_market.view.chart.viewmodel.ChartViewModel
import dagger.android.support.AndroidSupportInjection
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ErrorFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = ErrorFragmentBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(activity!!, factory)[ChartViewModel::class.java]

        view.retryButton
            .clicks()
            .throttleFirst(10, TimeUnit.SECONDS)
            .subscribe {
                viewModel.fetchChart()
            }

        return view.root
    }
}
