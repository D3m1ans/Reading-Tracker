package com.n1cks.core.domain.factory

import com.n1cks.core.domain.repository.BookRepository
import com.n1cks.core.domain.usecase.AddBookUseCase
import com.n1cks.core.domain.usecase.DeleteBookUseCase
import com.n1cks.core.domain.usecase.GetAllBooksUseCase
import com.n1cks.core.domain.usecase.GetBookByIdUseCase
import com.n1cks.core.domain.usecase.GetBooksByAuthorUseCase
import com.n1cks.core.domain.usecase.GetBooksByGenreUseCase
import com.n1cks.core.domain.usecase.GetBooksByRatingUseCase
import com.n1cks.core.domain.usecase.GetBooksByStatusUseCase
import com.n1cks.core.domain.usecase.GetBooksByYearUseCase
import com.n1cks.core.domain.usecase.SearchBooksUseCase
import com.n1cks.core.domain.usecase.UpdateBookUseCase

class UseCaseFactory(
    private val repository: BookRepository
) {
    fun provideGetAllBooksUseCase(): GetAllBooksUseCase {
        return GetAllBooksUseCase(repository)
    }

    fun provideGetBookByIdUseCase(): GetBookByIdUseCase {
        return GetBookByIdUseCase(repository)
    }

    fun provideGetBooksByStatusUseCase(): GetBooksByStatusUseCase {
        return GetBooksByStatusUseCase(repository)
    }

    fun provideGetBooksByGenreUseCase(): GetBooksByGenreUseCase {
        return GetBooksByGenreUseCase(repository)
    }

    fun provideGetBooksByRatingUseCase(): GetBooksByRatingUseCase {
        return GetBooksByRatingUseCase(repository)
    }

    fun provideGetBooksByAuthorUseCase(): GetBooksByAuthorUseCase {
        return GetBooksByAuthorUseCase(repository)
    }

    fun provideGetBooksByYearUseCase(): GetBooksByYearUseCase {
        return GetBooksByYearUseCase(repository)
    }

    fun provideSearchBooksUseCase(): SearchBooksUseCase {
        return SearchBooksUseCase(repository)
    }
    fun provideAddBookUseCase(): AddBookUseCase {
        return AddBookUseCase(repository)
    }

    fun provideDeleteBookUseCase(): DeleteBookUseCase {
        return DeleteBookUseCase(repository)
    }

    fun provideUpdateBookUseCase(): UpdateBookUseCase {
        return UpdateBookUseCase(repository)
    }
}