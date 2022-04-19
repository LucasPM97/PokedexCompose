package com.lucas.pokedexcompose.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.ui.theme.PokedexPokemonBackground
import com.lucas.pokedexcompose.ui.theme.PokedexPokemonStroke

@Composable
fun PokeCardBox(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    val shape = MaterialTheme.shapes.small

    Box(
        modifier = modifier
            .background(
                PokedexPokemonBackground,
                shape
            )
            .border(
                BorderStroke(5.dp, PokedexPokemonStroke),
                shape
            )
    ) {
        content()
    }
}