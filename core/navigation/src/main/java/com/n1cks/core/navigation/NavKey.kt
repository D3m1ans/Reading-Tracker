package com.n1cks.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface NavKey {
    @Serializable
    data object Library: NavKey
    @Serializable
    data class BookDetails(val id: Long) : NavKey
}