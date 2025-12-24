package com.n1cks.readingtracker.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.n1cks.core.domain.factory.UseCaseFactory
import com.n1cks.core.navigation.NavigationSource
import com.n1cks.core.navigation.Router
import javax.inject.Inject

class RootComponent @Inject constructor(
    componentContext: ComponentContext,
    private val useCaseFactory: UseCaseFactory
) : Router, ComponentContext by componentContext {

    private val navigation = StackNavigation<NavigationSource>()

    private val _stack = childStack(
        source = navigation,
        initialConfiguration = NavigationSource.Library,
        serializer = NavigationSource.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    )

    val stack: Value<ChildStack<NavigationSource, Any>> = _stack

    override val state: Value<Router.ChildNavState>
        get() = stack.map { childStack ->
            Router.ChildNavState(
                activeChild = childStack.active.configuration,
                backStack = childStack.backStack.map { it.configuration }
            )
        }


    override fun navigateToLibrary() {
        navigation.bringToFront(NavigationSource.Library)
    }

    override fun navigateToBookDetails(bookId: Long?) {
        navigation.bringToFront(NavigationSource.BookDetails(bookId))
    }

    override fun navigateToBack() {
        navigation.pop()
    }

    private fun createChild(
        config: NavigationSource,
        context: ComponentContext
    ) : Any = when(config) {
        is NavigationSource.Library -> TODO()
        is NavigationSource.BookDetails -> TODO()
    }
}