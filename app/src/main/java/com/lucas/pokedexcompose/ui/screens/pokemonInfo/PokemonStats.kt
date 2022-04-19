package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.data.models.PokemonInfoEntry
import com.lucas.pokedexcompose.data.remote.responses.TypeInfo
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokemonStats(pokemonInfo: PokemonInfoEntry) {
    Column() {
        PokeBodyStats(
            height = pokemonInfo.height,
            weight = pokemonInfo.weight
        )
        Spacer(modifier = Modifier.height(20.dp))
        PokemonTypeRow(
            types = pokemonInfo.types
        )
    }
}

@Composable
@Preview
fun PreviewPokemonStats() {
    PokedexComposeTheme {
        PokemonStats(
            pokemonInfo = PokemonInfoEntry(
                height = 1.7f,
                name = "Charizard",
                types = listOf(
                    TypeInfo(
                        name = "fire",
                        url = ""
                    ),
                    TypeInfo(
                        name = "flying",
                        url = ""
                    )
                ),
                weight = 90.5f
            )
        )
    }
}