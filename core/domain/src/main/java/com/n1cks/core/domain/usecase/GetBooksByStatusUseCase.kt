package com.n1cks.core.domain.usecase

import com.n1cks.core.domain.model.Book
import com.n1cks.core.domain.model.BookStatus
import com.n1cks.core.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow

class GetBooksByStatusUseCase(
    private val repository: BookRepository
) {
    operator fun invoke(status: BookStatus) : Flow<List<Book>> {
        return repository.getBooksByStatus(status)
    }
}