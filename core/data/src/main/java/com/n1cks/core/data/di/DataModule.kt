package com.n1cks.core.data.di

import android.content.Context
import androidx.room.Room
import com.n1cks.core.data.local.dao.BookDao
import com.n1cks.core.data.local.db.BookDB
import com.n1cks.core.data.repository.BookRepositoryImpl
import com.n1cks.core.domain.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule{
    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context) : BookDB {
        return Room.databaseBuilder(
            context = context,
            BookDB::class.java,
            name = "book_db",
        ).build()
    }

    @Provides
    @Singleton
    fun provideDAO(db: BookDB) : BookDao {
        return db.bookDao()
    }

    @Provides
    @Singleton
    fun provideBookRepository(dao: BookDao) : BookRepository {
        return BookRepositoryImpl(dao)
    }
}