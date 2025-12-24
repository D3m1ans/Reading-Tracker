package com.n1cks.core.domain.model

data class Book(
    val id: Long = 0,
    val title: String,
    val author: String,
    val genre: Genre = Genre.FICTION,
    val year: Int? = null,
    val pages: Int? = null,
    val currentPages: Int = 0,
    val rating: Int? = null,
    val status: BookStatus = BookStatus.READING,
    val startDate: Long? = null,
    val finishDate: Long? = null,
    val notes: String? = null,
    val coverUrl: String? = null
)