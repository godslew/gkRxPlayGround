package com.godslew.gkrxplayground.extension

import io.reactivex.*
import io.reactivex.disposables.Disposable

fun <T> Observable<T>.bindTo(onNext: (T) -> Unit): Disposable = subscribe(onNext) {  }
fun <T> Observable<T>.execute(): Disposable = subscribe({}, { })

fun Completable.bindTo(onComplete: () -> Unit): Disposable = subscribe(onComplete) {  }
fun Completable.execute(): Disposable = subscribe({}, {  })

fun <T> Single<T>.bindTo(onSuccess: (T) -> Unit): Disposable = subscribe(onSuccess) {  }
fun <T> Single<T>.execute(): Disposable = subscribe({}, {  })

fun <T> Maybe<T>.bindTo(onSuccess: (T) -> Unit): Disposable = subscribe(onSuccess) {  }
fun <T> Maybe<T>.execute(): Disposable = subscribe({}, {  })

fun <T> Flowable<T>.bindTo(onNext: (T) -> Unit): Disposable = subscribe(onNext) {  }
