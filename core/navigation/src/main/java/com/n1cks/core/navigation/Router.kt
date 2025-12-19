package com.n1cks.core.navigation

interface Router {

    val state: Observable<ChildNavState>

    fun navigateToLibrary()

    fun navigateToBookDetails(bookId: Long? = null)

    fun navigateToBack()

    data class ChildNavState(
        val activeChild: NavigationSource,
        val backStack: List<NavigationSource>
    )
}