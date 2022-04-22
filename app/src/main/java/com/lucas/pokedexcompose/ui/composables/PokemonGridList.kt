package com.lucas.pokedexcompose.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.data.models.PokemonListEntry
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonGridList(
    pokemonList: List<PokemonListEntry>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(bottom = 10.dp),
    itemOnClick: (PokemonListEntry) -> Unit = {},
    onEndReach: () -> Unit = {},
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(pokemonList.size) { index ->

            if (index >= pokemonList.lastIndex) {
                onEndReach()
            }

            PokemonItemCard(
                pokemonList[index],
                modifier = Modifier
                    .height(170.dp)
                    .clickable {
                        itemOnClick(pokemonList[index])
                    }
            )
        }
    }
}

@Composable
@Preview
fun PreviewPokemonGridList() {
    PokedexComposeTheme() {
        PokemonGridList(
            pokemonList = listOf(
                PokemonListEntry("Charmander", 1),
                PokemonListEntry("Ivasaur", 2),
                PokemonListEntry("Venosaur", 3)
            )
        )
    }
}

