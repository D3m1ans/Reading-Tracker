package com.n1cks.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.n1cks.core.domain.model.BookStatus
import com.n1cks.core.domain.model.Genre

@Entity(tableName = "book")
data class BookEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
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