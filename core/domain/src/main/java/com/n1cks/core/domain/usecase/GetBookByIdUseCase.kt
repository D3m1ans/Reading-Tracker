package com.n1cks.core.domain.usecase

import com.n1cks.core.domain.model.Book
import com.n1cks.core.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow

class GetBookByIdUseCase(
    private val repository: BookRepository
) {
    operator fun invoke(id: Long) : Flow<Book?> {
        return repository.getBookById(id)
    }
}