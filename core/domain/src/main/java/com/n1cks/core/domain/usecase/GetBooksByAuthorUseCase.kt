package com.n1cks.core.domain.usecase

import com.n1cks.core.domain.model.Book
import com.n1cks.core.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow

class GetBooksByAuthorUseCase(
    private val repository: BookRepository
) {
    operator fun invoke(author: String) : Flow<List<Book>> {
        return repository.getBooksByAuthor(author)
    }
}