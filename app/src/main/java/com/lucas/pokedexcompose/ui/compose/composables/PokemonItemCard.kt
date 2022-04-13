package com.lucas.pokedexcompose.ui.compose.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.data.remote.responses.PokemonItem
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.ui.theme.PokedexPokemonBackground
import com.lucas.pokedexcompose.ui.theme.PokedexPokemonStroke

@Composable
fun PokemonItemCard(
    pokemonItem: PokemonItem,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(10)

    Column(
        modifier = modifier
            .background(
                PokedexPokemonBackground,
                shape
            )
            .border(
                BorderStroke(5.dp, PokedexPokemonStroke),
                shape
            )
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PokemonImage(
            pokemonId = 10,
            imageSize = 120
        )
        Text(
            text = pokemonItem.name
        )
    }
}

@Composable
@Preview
fun PreviewPokemonItemCard() {
    PokedexComposeTheme {
        PokemonItemCard(
            pokemonItem = PokemonItem(
                name = "Pokemon",
            ),
            modifier = Modifier
                .size(120.dp)

        )
    }
}