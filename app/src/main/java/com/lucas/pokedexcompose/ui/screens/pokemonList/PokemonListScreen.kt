package com.lucas.pokedexcompose.ui.screens.pokemonList

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.lucas.pokedexcompose.data.models.PokemonListEntry
import com.lucas.pokedexcompose.ui.navigateToPokemonInfoScreen
import com.lucas.pokedexcompose.ui.PokemonViewModelFactory
import com.lucas.pokedexcompose.ui.ViewModels
import com.lucas.pokedexcompose.ui.composables.PokeScreen
import com.lucas.pokedexcompose.ui.composables.PokemonGridList
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
fun PokemonListBody(
    state: PokemonListUiState,
    viewModel: PokemonListViewModel? = null,
    navController: NavController? = null
) {
    var searchString by rememberSaveable {
        mutableStateOf("")
    }

    val pokemonList = state.pokemonList.filter {
        it.pokemonName.lowercase().contains(searchString.lowercase())
    }

    PokeScreen(
        isLoading = state.loading &&
                state.pokemonList.isNullOrEmpty()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .padding(top = 10.dp)
        ) {
            SearchBar(
                text = searchString,
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
                    navController?.navigateToPokemonInfoScreen(
                        it.pokemonName,
                        it.number
                    )
                }
            )
        }
    }
}

fun MockState(): PokemonListUiState {
    val list = mutableListOf<PokemonListEntry>()
    for (i in 0..20) {
        list.add(
            PokemonListEntry(
                "????",
                number = i
            )
        )
    }
    return PokemonListUiState(
        pokemonList = list,
    )
}

@Composable
@Preview
fun PreviewPokemonListScreen() {
    PokedexComposeTheme {
        PokemonListBody(
            state = MockState()
        )
    }
}