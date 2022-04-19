package com.lucas.pokedexcompose.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.lucas.pokedexcompose.ui.theme.PokedexBackground

@Composable
fun PokeScreen(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Surface(
        color = PokedexBackground,
        modifier = Modifier
            .fillMaxSize()
            .composed {
                modifier
            },
        content = content
    )
}