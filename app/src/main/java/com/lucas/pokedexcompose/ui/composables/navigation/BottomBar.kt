package com.lucas.pokedexcompose.ui.composables.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.lucas.pokedexcompose.ui.theme.PokedexTopBottomBar

@Composable
fun BottomBar(navController: NavController) {
    BottomAppBar(
        backgroundColor = PokedexTopBottomBar
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            BackButton(navController)
        }
    }
}