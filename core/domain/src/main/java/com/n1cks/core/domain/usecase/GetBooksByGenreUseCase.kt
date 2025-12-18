package com.n1cks.core.domain.usecase

import com.n1cks.core.domain.model.Book
import com.n1cks.core.domain.model.Genre
import com.n1cks.core.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow

class GetBooksByGenreUseCase(
    private val repository: BookRepository
) {
    operator fun invoke(genre: Genre) : Flow<List<Book>> {
        return repository.getBooksByGenre(genre)
    }
}