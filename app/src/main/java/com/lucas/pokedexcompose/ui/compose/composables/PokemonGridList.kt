package com.lucas.pokedexcompose.ui.compose.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.data.remote.responses.PokemonItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonGridList(
    pokemonList: List<PokemonItem>,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(pokemonList.size) { index ->
            PokemonItemCard(
                pokemonList[index]
            )
        }
    }
}

