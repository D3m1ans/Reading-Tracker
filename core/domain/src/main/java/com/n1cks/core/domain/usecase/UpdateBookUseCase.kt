package com.n1cks.core.domain.usecase

import com.n1cks.core.domain.model.Book
import com.n1cks.core.domain.repository.BookRepository

class UpdateBookUseCase(
    private val repository: BookRepository
) {
    suspend operator fun invoke(book: Book) {
        repository.updateBook(book)
    }
}