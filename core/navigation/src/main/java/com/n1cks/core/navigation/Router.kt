package com.n1cks.core.navigation

import com.arkivanov.decompose.value.Value

interface Router {
    fun navigateToLibrary()

    fun navigateToBookDetails(bookId: Long)

    fun navigateToBack()
}