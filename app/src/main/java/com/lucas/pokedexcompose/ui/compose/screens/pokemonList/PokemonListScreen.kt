package com.lucas.pokedexcompose.ui.compose.screens.pokemonList

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lucas.pokedexcompose.data.remote.responses.PokemonItem
import com.lucas.pokedexcompose.ui.compose.composables.PokemonGridList
import com.lucas.pokedexcompose.ui.theme.PokedexBackground

@Composable
fun PokemonListScreen(
    navController: NavController
) {
    Surface(
        color = PokedexBackground,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            SearchBar(
                hint = "Search...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

            }
            PokemonGridList(
                pokemonList = listOf(
                    PokemonItem("Ditto"),
                    PokemonItem("Ditto 2"),
                    PokemonItem("Ditto 3"),
                ),
                contentPadding = PaddingValues(horizontal = 10.dp)
            )
        }
    }

}