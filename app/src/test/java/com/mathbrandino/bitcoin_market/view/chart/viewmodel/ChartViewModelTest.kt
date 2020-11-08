package com.mathbrandino.bitcoin_market.view.chart.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mathbrandino.bitcoin_market.data.model.BitcoinChartResponse
import com.mathbrandino.bitcoin_market.data.model.ChartEntry
import com.mathbrandino.bitcoin_market.data.repository.ChartRepository
import com.mathbrandino.bitcoin_market.view.chart.RxSchedulerRule
import com.mathbrandino.bitcoin_market.view.chart.mapper.ChartInformationBuilder
import com.mathbrandino.bitcoin_market.view.chart.model.ChartInformation
import com.mathbrandino.bitcoin_market.view.chart.model.ChartInformationState
import com.mathbrandino.bitcoin_market.view.chart.model.ChartInformationState.*
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class ChartViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rxSchedulerRule = RxSchedulerRule()

    @Mock
    lateinit var observer: Observer<ChartInformationState>

    @Mock
    lateinit var repository: ChartRepository

    private lateinit var viewModel: ChartViewModel
    private lateinit var response: BitcoinChartResponse
    private lateinit var list: ArrayList<ChartInformation>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = ChartViewModel(repository)

        response = BitcoinChartResponse(
            status = "ok",
            name = "Market Price",
            period = "Day",
            description = "Some Description",
            entries = arrayListOf(
                ChartEntry(timestamp = 1573257600, value = 8766.04)
            )
        )

        list = arrayListOf(ChartInformationBuilder.build())
    }


    @Test
    fun `should emits the loading and after the loaded states without error`() {
        viewModel.state.observeForever(observer)

        whenever(repository.fetchCharts()).thenReturn(Single.just(arrayListOf(response)))
        viewModel.fetchChart()

        verify(observer).onChanged(Loading)
        verify(observer).onChanged(Loaded(list))
        verify(observer, never()).onChanged(Error)
    }

    @Test
    fun `should emits the loading and after the error states when some error occurs`() {
        viewModel.state.observeForever(observer)

        doReturn(Single.just(Throwable())).whenever(repository).fetchCharts()
        viewModel.fetchChart()

        verify(observer).onChanged(Loading)
        verify(observer, never()).onChanged(Loaded(list))
        verify(observer).onChanged(Error)
    }
}
