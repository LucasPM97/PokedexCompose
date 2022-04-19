package com.lucas.pokedexcompose.ui

import androidx.navigation.NavController
import com.lucas.pokedexcompose.utils.Constans.Screens.PokemonInfoScreenName
import com.lucas.pokedexcompose.utils.Constans.Screens.PokemonTypeInfoScreenName

fun NavController.NavigateToPokemonInfoScreen(pokemonName: String, pokemonNumber: Int) {
    this.navigate(
        "$PokemonInfoScreenName/${pokemonName}/${pokemonNumber}"
    )
}
fun NavController.NavigateToPokemonTypeInfoScreen(pokemonTypeName: String) {
    this.navigate(
        "$PokemonTypeInfoScreenName/${pokemonTypeName}"
    )
}