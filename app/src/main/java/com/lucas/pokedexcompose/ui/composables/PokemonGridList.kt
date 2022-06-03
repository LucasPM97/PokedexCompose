package com.lucas.pokedexcompose.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.data.models.PokemonListEntry
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokemonGridList(
    pokemonList: List<PokemonListEntry>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(bottom = 10.dp),
    itemOnClick: (PokemonListEntry) -> Unit = {},
    onEndReach: () -> Unit = {},
    header: @Composable () -> Unit = {
        EmptyComposable()
    }
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        item(
            span = {
                GridItemSpan(maxCurrentLineSpan)
            }
        ) {
            header()
        }
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

