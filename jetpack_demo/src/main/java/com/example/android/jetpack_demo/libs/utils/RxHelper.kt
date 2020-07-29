package com.example.android.jetpack_demo.libs.utils

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class RxHelper {
    companion object {
        /**
         *upstream io
         * Downstream mainThread
         */
        fun <T> rxScheduler(): ObservableTransformer<T, T> {
            return ObservableTransformer<T, T>() {
                return@ObservableTransformer it.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
        }

        /**
         *生成Flowable
         */
        fun <T> createFlowable(t: T): Flowable<T> {
            return Flowable.create(
                {
                    try {
                        it.onNext(t)
                        it.onComplete()
                    } catch (e: Exception) {
                        it.onError(e)
                    }

                }, BackpressureStrategy.BUFFER
            )
        }

        /**
         *生成Observable
         */
        fun <T> createObservable(t: T): Observable<T> {
            return Observable.create {
                try {
                    it.onNext(t)
                    it.onComplete()
                } catch (e: Exception) {
                    it.onError(e)
                }
            }
        }
    }
}