package com.n1cks.core.domain.di

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
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetAllBooksUseCase(repository: BookRepository): GetAllBooksUseCase {
        return GetAllBooksUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetBookByIdUseCase(repository: BookRepository): GetBookByIdUseCase {
        return GetBookByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetBooksByStatusUseCase(repository: BookRepository): GetBooksByStatusUseCase {
        return GetBooksByStatusUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetBooksByGenreUseCase(repository: BookRepository): GetBooksByGenreUseCase {
        return GetBooksByGenreUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetBooksByRatingUseCase(repository: BookRepository): GetBooksByRatingUseCase {
        return GetBooksByRatingUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetBooksByAuthorUseCase(repository: BookRepository): GetBooksByAuthorUseCase {
        return GetBooksByAuthorUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetBooksByYearUseCase(repository: BookRepository): GetBooksByYearUseCase {
        return GetBooksByYearUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSearchBooksUseCase(repository: BookRepository): SearchBooksUseCase {
        return SearchBooksUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAddBookUseCase(repository: BookRepository): AddBookUseCase {
        return AddBookUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteBookUseCase(repository: BookRepository): DeleteBookUseCase {
        return DeleteBookUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUpdateBookUseCase(repository: BookRepository): UpdateBookUseCase {
        return UpdateBookUseCase(repository)
    }
}