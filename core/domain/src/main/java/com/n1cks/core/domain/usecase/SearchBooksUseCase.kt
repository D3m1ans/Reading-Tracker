package com.n1cks.core.domain.usecase

import com.n1cks.core.domain.model.Book
import com.n1cks.core.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow

class SearchBooksUseCase(
    private val repository: BookRepository
) {
    operator fun invoke(query: String) : Flow<List<Book>> {
        return repository.searchBooks(query)
    }
}