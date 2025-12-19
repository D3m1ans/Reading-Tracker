package com.n1cks.core.data.repository

import com.n1cks.core.data.local.dao.BookDao
import com.n1cks.core.data.mapper.toBook
import com.n1cks.core.data.mapper.toEntity
import com.n1cks.core.domain.model.Book
import com.n1cks.core.domain.model.BookStatus
import com.n1cks.core.domain.model.Genre
import com.n1cks.core.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BookRepositoryImpl(
    private val dao: BookDao,
) : BookRepository {
    override fun getAllBooks(): Flow<List<Book>> {
        return dao.getAllBooks().map { bookEntities ->
            bookEntities.map { it.toBook() }
        }
    }

    override fun getBookById(id: Long): Flow<Book?> {
        return dao.getBookById(id).map {entity -> entity?.toBook() }
    }

    override fun getBooksByStatus(status: BookStatus): Flow<List<Book>> {
        return dao.getBooksByStatus(status).map { bookEntities ->
            bookEntities.map { it.toBook() }
        }
    }

    override fun getBooksByGenre(genre: Genre): Flow<List<Book>> {
        return dao.getBooksByGenre(genre).map { bookEntities ->
            bookEntities.map { it.toBook() }
        }
    }

    override fun getBooksByRating(rating: Float): Flow<List<Book>> {
        return dao.getBooksByRating(rating).map { bookEntities ->
            bookEntities.map { it.toBook() }
        }
    }

    override fun getBooksByAuthor(author: String): Flow<List<Book>> {
        return dao.getBooksByAuthor(author).map { bookEntities ->
            bookEntities.map { it.toBook() }
        }
    }

    override fun getBooksByYearRange(
        startYear: Int,
        endYear: Int
    ): Flow<List<Book>> {
        return dao.getBooksByYearRange(startYear, endYear).map { bookEntities ->
            bookEntities.map { it.toBook() }
        }
    }

    override fun searchBooks(query: String): Flow<List<Book>> {
        return dao.searchBooks(query).map { bookEntities ->
            bookEntities.map { it.toBook() }
        }
    }

    override suspend fun addBook(book: Book) {
        dao.addBook(book = book.toEntity())
    }

    override suspend fun deleteBook(book: Book) {
        dao.deleteBook(book = book.toEntity())
    }

    override suspend fun updateBook(book: Book) {
        dao.updateBook(book = book.toEntity())
    }
}