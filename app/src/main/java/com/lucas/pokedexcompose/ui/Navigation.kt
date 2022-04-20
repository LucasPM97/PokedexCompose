package com.lucas.pokedexcompose.ui

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.lucas.pokedexcompose.utils.Constans.Screens.PokemonInfoScreenName
import com.lucas.pokedexcompose.utils.Constans.Screens.PokemonTypeInfoScreenName

fun NavController.navigateToPokemonInfoScreen(pokemonName: String, pokemonNumber: Int) {
    this.navigate(
        "$PokemonInfoScreenName/${pokemonName}/${pokemonNumber}"
    )
}

fun NavController.navigateToPokemonTypeInfoScreen(pokemonTypeName: String) {
    this.navigate(
        "$PokemonTypeInfoScreenName/${pokemonTypeName}"
    )
}
