package com.mathbrandino.bitcoin_market.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mathbrandino.bitcoin_market.data.repository.ChartRepository
import com.mathbrandino.bitcoin_market.view.chart.viewmodel.ChartViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor() :
    ViewModelProvider.Factory {

    @Inject
    lateinit var repository: ChartRepository;

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when (modelClass) {
        ChartViewModel::class.java -> ChartViewModel(repository) as T
        else -> throw IllegalArgumentException("Factory cannot make ViewModel of type ${modelClass.simpleName}")
    }
}
