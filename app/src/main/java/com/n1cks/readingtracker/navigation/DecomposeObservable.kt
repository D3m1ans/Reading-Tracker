package com.n1cks.readingtracker.navigation

import com.arkivanov.decompose.value.Value
import com.n1cks.core.navigation.Observable

class DecomposeObservable<T : Any>(
    private val decomposeValue: Value<T>
) : Observable<T> {
    override val value: T
        get() = decomposeValue.value

    override fun observe(observer: (T) -> Unit) {
        decomposeValue.subscribe { observer(it) }
    }
}