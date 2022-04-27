package com.lucas.pokedexcompose.ui.composables.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BackButton(navController: NavController?) {
    BottomBarRowIconButton(
        icon = Icons.Filled.ArrowBack,
        text = "Back"
    ) {
        navController?.popBackStack()
    }
}