package com.lucas.pokedexcompose.ui.pokemonList

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.lucas.pokedexcompose.ui.PokemonListViewModelFactory
import com.lucas.pokedexcompose.ui.composables.PokemonGridList
import com.lucas.pokedexcompose.ui.theme.PokedexBackground

@Composable
fun PokemonListScreen(
    navController: NavController,
    viewModel: PokemonListViewModel = viewModel(
        factory = PokemonListViewModelFactory()
    )
) {

    val state by viewModel.uiState.collectAsState()

    var searchString by remember {
        mutableStateOf("")
    }

    val pokemonList = state.pokemonList.filter {
        it.pokemonName.lowercase().contains(searchString.lowercase())
    }

    Surface(
        color = PokedexBackground,
        modifier = Modifier.fillMaxSize()
    ) {
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
                    viewModel.loadPokemonListPage()
                },
                itemOnClick = {

                }
            )
        }
    }
}