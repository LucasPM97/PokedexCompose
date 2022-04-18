package com.lucas.pokedexcompose.ui

import androidx.navigation.NavController
import com.lucas.pokedexcompose.utils.Constans.Screens.PokemonInfoScreenName

fun NavController.NavigateToPokemonInfoScreen(pokemonName: String, pokemonNumber: Int) {
    this.navigate(
        "$PokemonInfoScreenName/${pokemonName}/${pokemonNumber}"
    )
}