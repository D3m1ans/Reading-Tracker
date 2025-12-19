package com.n1cks.readingtracker.root.content

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.n1cks.readingtracker.root.component.RootComponent

@Composable
fun RootContent(component: RootComponent) {
    Children(
        stack = component.stack
    ) { child ->
        when (val instance = child.instance) {

        }
    }
}