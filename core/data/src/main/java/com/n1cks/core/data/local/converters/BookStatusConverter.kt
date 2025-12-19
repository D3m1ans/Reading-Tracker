package com.n1cks.core.data.local.converters

import androidx.room.TypeConverter
import com.n1cks.core.domain.model.BookStatus


class BookStatusConverter {
    @TypeConverter
    fun fromString(value: String?): BookStatus? {
        return value?.let { BookStatus.valueOf(it) }
    }

    @TypeConverter
    fun toString(status: BookStatus?): String? {
        return status?.name
    }
}