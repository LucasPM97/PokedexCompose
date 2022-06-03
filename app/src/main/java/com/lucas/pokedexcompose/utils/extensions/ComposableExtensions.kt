package com.lucas.pokedexcompose.utils.extensions

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

enum class WindowSize { COMPACT, MEDIUM, EXPANDED }

@Composable
fun BoxWithConstraintsScope.windowSize(): WindowSize {
    return if (maxWidth > 840.dp) WindowSize.EXPANDED
    else if (maxWidth > 600.dp) WindowSize.MEDIUM
    else WindowSize.COMPACT
}