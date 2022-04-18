package com.lucas.pokedexcompose.ui.pokemonInfo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.lucas.pokedexcompose.ui.theme.PokedexBackground

@Composable
fun PokemonInfoScreen(
    navController: NavController,
    viewModel: PokemonInfoViewModel
) {
    val state by viewModel.uiState.collectAsState()


    Surface(
        color = PokedexBackground,
        modifier = Modifier.fillMaxSize()
    ) {

    }
}


