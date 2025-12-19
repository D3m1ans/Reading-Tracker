package com.n1cks.core.data.local.converters

import androidx.room.TypeConverter
import com.n1cks.core.domain.model.Genre

class GenreConverter {
    @TypeConverter
    fun fromString(value: String?): Genre? {
        return value?.let { Genre.valueOf(it) }
    }

    @TypeConverter
    fun toString(genre: Genre?): String? {
        return genre?.name
    }
}