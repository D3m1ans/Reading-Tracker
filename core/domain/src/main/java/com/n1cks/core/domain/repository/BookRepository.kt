package com.n1cks.core.domain.repository

import com.n1cks.core.domain.model.Book
import com.n1cks.core.domain.model.BookStatus
import com.n1cks.core.domain.model.Genre
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getAllBooks() : Flow<List<Book>>
    fun getBookById(id: Long) : Flow<Book?>

    fun getBooksByStatus(status: BookStatus) : Flow<List<Book>>
    fun getBooksByGenre(genre: Genre) : Flow<List<Book>>
    fun getBooksByRating(rating: Float) : Flow<List<Book>>
    fun getBooksByAuthor(author: String) : Flow<List<Book>>
    fun getBooksByYear(year: Int) : Flow<List<Book>>

    fun searchBooks(query: String) : Flow<List<Book>>

    suspend fun addBook(book: Book)
    suspend fun deleteBook(book: Book)
    suspend fun updateBook(book: Book)
}