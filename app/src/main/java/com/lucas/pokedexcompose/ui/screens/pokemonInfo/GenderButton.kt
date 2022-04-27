package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import com.lucas.pokedexcompose.ui.composables.navigation.BottomBarRowIconButton

@Composable
fun GenderButton(
    isVisible: Boolean?,
    maleGender: Boolean,
    onClick: () -> Unit = {}
) {
    if (isVisible != true) return
    BottomBarRowIconButton(
        icon = if (maleGender) Icons.Filled.Male
        else Icons.Filled.Female,
        text = if (maleGender) "Male" else "Female"
    ) {
        onClick()
    }
}