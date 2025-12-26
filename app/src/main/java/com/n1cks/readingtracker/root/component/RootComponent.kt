package com.n1cks.readingtracker.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.n1cks.core.domain.usecase.AddBookUseCase
import com.n1cks.core.domain.usecase.GetAllBooksUseCase
import com.n1cks.core.navigation.NavKey
import com.n1cks.core.navigation.Router
import com.n1cks.features.library.component.LibraryComponent
import javax.inject.Inject

class RootComponent @Inject constructor(
    componentContext: ComponentContext,
    private val getAllBooksUseCase: GetAllBooksUseCase,
    private val addBookUseCase: AddBookUseCase
) : Router, ComponentContext by componentContext {

    private val navigation = StackNavigation<NavKey>()

    private val _stack = childStack(
        source = navigation,
        initialConfiguration = NavKey.Library,
        serializer = NavKey.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    )

    val stack: Value<ChildStack<NavKey, Any>> = _stack


    override fun navigateToLibrary() {
        navigation.bringToFront(NavKey.Library)
    }

    override fun navigateToBookDetails(bookId: Long) {
        navigation.bringToFront(NavKey.BookDetails(bookId))
    }

    override fun navigateToBack() {
        navigation.pop()
    }

    private fun createChild(
        config: NavKey,
        context: ComponentContext
    ): Any = when (config) {
        is NavKey.Library -> LibraryComponent(
            context,
            getAllBooksUseCase,
            addBookUseCase,
            router = this
        )

        is NavKey.BookDetails -> TODO()
    }
}