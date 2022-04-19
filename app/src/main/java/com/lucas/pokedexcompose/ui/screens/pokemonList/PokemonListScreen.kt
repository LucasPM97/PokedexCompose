package com.lucas.pokedexcompose.ui.screens.pokemonList

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.lucas.pokedexcompose.data.models.PokemonListEntry
import com.lucas.pokedexcompose.ui.NavigateToPokemonInfoScreen
import com.lucas.pokedexcompose.ui.PokemonViewModelFactory
import com.lucas.pokedexcompose.ui.ViewModels
import com.lucas.pokedexcompose.ui.composables.PokeScreen
import com.lucas.pokedexcompose.ui.composables.PokemonGridList
import com.lucas.pokedexcompose.ui.theme.PokedexBackground
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokemonListScreen(
    navController: NavController,
    viewModel: PokemonListViewModel = viewModel(
        factory = PokemonViewModelFactory(
            ViewModels.PokemonList
        )
    )
) {

    val state by viewModel.uiState.collectAsState()

    PokemonListBody(state, viewModel, navController)
}

@Composable
private fun PokemonListBody(
    state: PokemonListUiState,
    viewModel: PokemonListViewModel? = null,
    navController: NavController? = null
) {
    var searchString by remember {
        mutableStateOf("")
    }

    val pokemonList = state.pokemonList.filter {
        it.pokemonName.lowercase().contains(searchString.lowercase())
    }

    PokeScreen {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            SearchBar(
                hint = "Search...",
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                searchString = it
            }
            Spacer(modifier = Modifier.height(10.dp))
            PokemonGridList(
                pokemonList = pokemonList,
                onEndReach = {
                    viewModel?.loadPokemonListPage()
                },
                itemOnClick = {
                    navController?.NavigateToPokemonInfoScreen(
                        it.pokemonName,
                        it.number
                    )
                }
            )
        }
    }
}

@Composable
@Preview
fun PreviewPokemonListScreen() {
    PokedexComposeTheme {
        PokemonListBody(
            state = PokemonListUiState(
                pokemonList = listOf(
                    PokemonListEntry(
                        "????",
                        number = 1
                    ),
                    PokemonListEntry(
                        "????",
                        number = 1
                    ),
                    PokemonListEntry(
                        "????",
                        number = 1
                    ),
                ),
                loading = false
            )
        )
    }
}