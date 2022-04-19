package com.lucas.pokedexcompose.utils

import androidx.compose.ui.graphics.Color
import com.lucas.pokedexcompose.ui.theme.*

object PokemonTypeColorHelper {

    fun getPokemonTypeColor(pokemonType: String): Color {
        return when (pokemonType) {
            "normal" -> TypeNormal
            "fighting" -> TypeFighting
            "flying" -> TypeFlying
            "poison" -> TypePoison
            "ground" -> TypeGround
            "rock" -> TypeRock
            "bug" -> TypeBug
            "ghost" -> TypeGhost
            "steel" -> TypeSteel
            "fire" -> TypeFire
            "water" -> TypeWater
            "grass" -> TypeGrass
            "electric" -> TypeElectric
            "psychic" -> TypePsychic
            "ice" -> TypeIce
            "dragon" -> TypeDragon
            "dark" -> TypeDark
            "fairy" -> TypeFairy
            else -> TypeNormal
        }
    }
}