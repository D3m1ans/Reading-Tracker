package com.n1cks.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationSource {
    @Serializable
    data object Library: NavigationSource()
    @Serializable
    data class BookDetails(val id: Long?) : NavigationSource()
}