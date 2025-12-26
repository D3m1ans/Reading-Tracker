package com.n1cks.readingtracker.root.content

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.n1cks.core.navigation.NavKey
import com.n1cks.features.library.component.LibraryComponent
import com.n1cks.readingtracker.root.component.RootComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootContent(component: RootComponent) {

    val stack by component.stack.subscribeAsState()

    val title = when (val config = stack.active.configuration) {
        is NavKey.Library -> "Library"
        is NavKey.BookDetails -> "Details"
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(title) })
        }
    ) { paddingValues ->
        Children(
            stack = component.stack,
            modifier = Modifier.padding(paddingValues)
        ) {
            when (val child = it.instance) {
                is LibraryComponent -> TODO()

            }
        }
    }
}