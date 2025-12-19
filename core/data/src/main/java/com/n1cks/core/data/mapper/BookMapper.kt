package com.n1cks.core.data.mapper

import com.n1cks.core.data.local.entity.BookEntity
import com.n1cks.core.domain.model.Book

fun Book.toEntity() : BookEntity {
    return BookEntity(
        id = id,
        title = title,
        author = author,
        genre = genre,
        year = year,
        pages = pages,
        rating = rating,
        status = status,
        startDate = startDate,
        finishDate = finishDate,
        notes = notes,
        coverUrl = coverUrl
    )
}

fun BookEntity.toBook() : Book {
    return Book(
        id = id,
        title = title,
        author = author,
        genre = genre,
        year = year,
        pages = pages,
        rating = rating,
        status = status,
        startDate = startDate,
        finishDate = finishDate,
        notes = notes,
        coverUrl = coverUrl
    )
}