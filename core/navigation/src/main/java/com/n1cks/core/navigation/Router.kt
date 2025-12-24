package com.n1cks.core.navigation

import com.arkivanov.decompose.value.Value

interface Router {

    val state: Value<ChildNavState>

    fun navigateToLibrary()

    fun navigateToBookDetails(bookId: Long? = null)

    fun navigateToBack()

    data class ChildNavState(
        val activeChild: NavigationSource,
        val backStack: List<NavigationSource>
    )
}