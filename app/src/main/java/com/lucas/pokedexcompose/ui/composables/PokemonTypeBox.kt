package com.lucas.pokedexcompose.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.utils.PokemonTypeColorHelper

@Composable
fun PokemonTypeBox(
    typeName: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(
                PokemonTypeColorHelper.getPokemonTypeColor(typeName),
                MaterialTheme.shapes.small
            )
            .composed {
                modifier
            }
    ) {
        Text(
            text = typeName.uppercase(),
            color = Color.White,
            fontSize = fontSize
        )
    }
}

@Composable
@Preview
fun PreviewPokemonTypeBox() {
    PokedexComposeTheme {
        PokemonTypeBox(
            "fire"
        )
    }
}