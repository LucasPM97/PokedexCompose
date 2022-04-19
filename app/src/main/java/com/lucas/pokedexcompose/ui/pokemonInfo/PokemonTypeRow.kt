package com.lucas.pokedexcompose.ui.pokemonInfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.data.remote.responses.TypeInfo
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.utils.PokemonTypeColorHelper

@Composable
fun PokemonTypeRow(types: List<TypeInfo>) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        types.forEachIndexed { index, type ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(
                        PokemonTypeColorHelper
                            .getPokemonTypeColor(type.name),
                        MaterialTheme.shapes.small
                    )
                    .padding(10.dp)
            ) {
                Text(
                    text = type.name.uppercase(),
                    color = Color.White
                )
            }
            if (types.size > 1 && index != types.lastIndex) {
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}

@Composable
@Preview
fun PreviewPokemonTypeRow() {
    PokedexComposeTheme {
        PokemonTypeRow(
            types = listOf(
                TypeInfo(
                    name = "fire",
                    ""
                ),
                TypeInfo(
                    name = "flying",
                    ""
                ),
            )
        )
    }
}