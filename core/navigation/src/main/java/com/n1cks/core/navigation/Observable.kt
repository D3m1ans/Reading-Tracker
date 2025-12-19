package com.n1cks.core.navigation

interface Observable<out T: Any> {
    val value: T
    fun observe(observer: (T) -> Unit)
}