package com.lucas.pokedexcompose.ui.pokemonInfo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lucas.pokedexcompose.data.models.PokemonInfoEntry
import com.lucas.pokedexcompose.data.remote.responses.*
import com.lucas.pokedexcompose.ui.composables.PokeCardBox
import com.lucas.pokedexcompose.ui.composables.PokemonImage
import com.lucas.pokedexcompose.ui.theme.PokedexBackground
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokemonInfoScreen(
    navController: NavController,
    viewModel: PokemonInfoViewModel
) {
    val state by viewModel.uiState.collectAsState()


    Surface(
        color = PokedexBackground,
        modifier = Modifier.fillMaxSize()
    ) {
        PokeCardBox(
            modifier = Modifier.padding(10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                PokemonImage(
                    pokemonId = state.pokemonNumber,
                    imageSize = 240,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = state.pokemonName
                        .replaceFirstChar {
                            it.uppercase()
                        }
                )
                Spacer(modifier = Modifier.height(20.dp))
                state.pokemonInfo?.let {
                    PokemonStats(pokemonInfo = it)
                }
            }
        }
    }
}

@Composable
fun PokemonStats(pokemonInfo: PokemonInfoEntry) {
    Column() {
        PokeBodyStats(
            height = pokemonInfo.height,
            weight = pokemonInfo.weight
        )
        Spacer(modifier = Modifier.height(20.dp))
        PokemonTypeData(
            types = pokemonInfo.types
        )
        Spacer(modifier = Modifier.height(20.dp))
    }

}

@Composable
@Preview
fun PreviewPokemonInfoBody() {
    PokedexComposeTheme {
        PokemonStats(
            pokemonInfo = PokemonInfoEntry(
                height = 1.7f,
                name = "Charizard",
                order = 7,
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


