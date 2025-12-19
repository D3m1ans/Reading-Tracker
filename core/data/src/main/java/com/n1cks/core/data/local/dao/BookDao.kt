package com.n1cks.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.n1cks.core.data.local.entity.BookEntity
import com.n1cks.core.domain.model.BookStatus
import com.n1cks.core.domain.model.Genre
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * FROM book")
    fun getAllBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM book WHERE id =:id")
    fun getBookById(id: Long): Flow<BookEntity?>

    @Query("SELECT * FROM book WHERE status =:status")
    fun getBooksByStatus(status: BookStatus): Flow<List<BookEntity>>

    @Query("SELECT * FROM book WHERE genre =:genre")
    fun getBooksByGenre(genre: Genre): Flow<List<BookEntity>>

    @Query("SELECT * FROM book WHERE rating >= rating AND rating IS NOT NULL")
    fun getBooksByRating(rating: Float): Flow<List<BookEntity>>

    @Query("SELECT * FROM book WHERE author LIKE '%' || :author || '%'")
    fun getBooksByAuthor(author: String): Flow<List<BookEntity>>

    @Query("SELECT * FROM book WHERE year BETWEEN :startYear AND :endYear")
    fun getBooksByYearRange(startYear: Int, endYear: Int): Flow<List<BookEntity>>

    @Query("SELECT * FROM book WHERE title LIKE '%' || :query || '%'")
    fun searchBooks(query: String): Flow<List<BookEntity>>

    @Insert
    suspend fun addBook(book: BookEntity)

    @Delete
    suspend fun deleteBook(book: BookEntity)

    @Update
    suspend fun updateBook(book: BookEntity)
}