package com.godslew.gkrxplayground.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.toObservable

class MainViewModel : ViewModel() {
    private val disposable = CompositeDisposable()
    fun createSingle() {
        val single = Single.create<List<Int>> {
            try {
                it.onSuccess(listOf(1, 2, 3, 4, 5))
            } catch (e: Error) {
                it.onError(e)
            }
        }
        single.subscribe { list -> Log.d("TAG", "snake00 list $list") }.addTo(disposable)

        listOf(1, 2, 3, 4, 5)
            .toObservable()
            .subscribe { list -> Log.d("TAG", "snake00 list ${list}") }
            .addTo(disposable)
    }
}
