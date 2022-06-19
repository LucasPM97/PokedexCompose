package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokeBodyStats(height: Float, weight: Float) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Height: ${height}m", fontSize = 12.sp)
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = "Weight: ${weight}kg", fontSize = 12.sp)
    }
}