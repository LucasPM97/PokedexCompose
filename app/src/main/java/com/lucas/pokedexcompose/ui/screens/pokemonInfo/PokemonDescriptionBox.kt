package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.pokedexcompose.ui.composables.PokeCardBox

@Composable
fun PokemonDescriptionBox(
    description: String?,
    modifier: Modifier = Modifier
) {
    description?.let {
        PokeCardBox(
            modifier = modifier
        ) {
            Text(
                text = it,
                fontSize = 14.sp,
                lineHeight = 30.sp,
                modifier = Modifier.padding(20.dp)
            )

        }
    }
}