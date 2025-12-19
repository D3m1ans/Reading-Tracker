package com.n1cks.readingtracker.di

import com.n1cks.core.domain.factory.UseCaseFactory
import com.n1cks.core.domain.repository.BookRepository
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
    fun provideUseCaseFactory(repository: BookRepository) : UseCaseFactory {
        return UseCaseFactory(repository)
    }
}