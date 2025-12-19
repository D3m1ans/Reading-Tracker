package com.n1cks.core.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.n1cks.core.data.local.converters.BookStatusConverter
import com.n1cks.core.data.local.converters.GenreConverter
import com.n1cks.core.data.local.entity.BookEntity

@Database(entities = [BookEntity::class], version = 1)
@TypeConverters(
    GenreConverter::class,
    BookStatusConverter::class
)
abstract class BookDB : RoomDatabase() {
    abstract fun bookDao()
}