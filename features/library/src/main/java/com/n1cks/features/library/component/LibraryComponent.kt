package com.n1cks.features.library.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.doOnDestroy
import com.n1cks.core.domain.model.Book
import com.n1cks.core.domain.usecase.AddBookUseCase
import com.n1cks.core.domain.usecase.GetAllBooksUseCase
import com.n1cks.core.navigation.Router
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class LibraryComponent(
    componentContext: ComponentContext,
    private val getAllBooksUseCase: GetAllBooksUseCase,
    private val addBookUseCase: AddBookUseCase,
    private val router: Router
): ComponentContext by componentContext {

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)
    private val _books = MutableValue<List<Book>>(emptyList())

    val books: Value<List<Book>> = _books


    init {
        componentContext.lifecycle.doOnDestroy {
            job.cancel()
        }

        scope.launch {
            getAllBooksUseCase().collect { books ->
                _books.value = books
            }
        }
    }

    fun onCreateBook() {
        scope.launch {
            val newBook = Book(
                title = "Новая книга",
                author = "Неизвестный автор"
            )
            addBookUseCase(newBook)
        }
    }

    fun onBookClick(id: Long) {
        router.navigateToBookDetails(id)
    }
}