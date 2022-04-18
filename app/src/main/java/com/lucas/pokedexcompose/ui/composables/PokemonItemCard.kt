package com.lucas.pokedexcompose.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.data.models.PokemonListEntry
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.ui.theme.PokedexPokemonBackground
import com.lucas.pokedexcompose.ui.theme.PokedexPokemonStroke

@Composable
fun PokemonItemCard(
    pokemonItem: PokemonListEntry,
    modifier: Modifier = Modifier
) {
    PokeCardBox(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PokemonImage(
                pokemonId = pokemonItem.number,
                imageSize = 120
            )
            Text(
                text = pokemonItem.pokemonName
            )
        }
    }

}

@Composable
@Preview
fun PreviewPokemonItemCard() {
    PokedexComposeTheme {
        PokemonItemCard(
            pokemonItem = PokemonListEntry(
                pokemonName = "Pokemon",
                number = 1
            ),
            modifier = Modifier
                .size(120.dp)
        )
    }
}