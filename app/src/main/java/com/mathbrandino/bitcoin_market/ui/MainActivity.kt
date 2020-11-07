package com.mathbrandino.bitcoin_market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mathbrandino.bitcoin_market.data.network.BitcoinService
import com.mathbrandino.bitcoin_market.data.network.RetrofitInitializer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val disposable =  CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        disposable.add(RetrofitInitializer
            .getInstance()
            .create(BitcoinService::class.java)
            .fetchChart()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ Log.d("result", "certo $it") }, { Log.e("result", "erro ${it.message}") }))
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
