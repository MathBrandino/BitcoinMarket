package com.mathbrandino.bitcoin_market.view.chart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mathbrandino.bitcoin_market.data.repository.ChartRepository
import com.mathbrandino.bitcoin_market.view.chart.mapper.ChartInformationMapper
import com.mathbrandino.bitcoin_market.view.chart.model.ChartInformationState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ChartViewModel(
    private val chartRepository: ChartRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val _state = MutableLiveData<ChartInformationState>()
    val state: LiveData<ChartInformationState> = _state

    fun fetchChart() {
        disposable.add(
            chartRepository.fetchCharts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { _state.postValue(ChartInformationState.Loading) }
                .map { it.map { response -> ChartInformationMapper.map(response) } as ArrayList }
                .subscribe(
                    {
                        _state.postValue(ChartInformationState.Loaded(it))
                    },
                    {
                        _state.postValue(ChartInformationState.Error("${it.message}"))
                    }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}
