package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lucas.pokedexcompose.data.models.PokemonInfoEntry
import com.lucas.pokedexcompose.data.remote.responses.TypeInfo
import com.lucas.pokedexcompose.ui.navigateToPokemonTypeInfoScreen
import com.lucas.pokedexcompose.ui.composables.PokeCardBox
import com.lucas.pokedexcompose.ui.composables.PokeScreen
import com.lucas.pokedexcompose.ui.composables.PokemonImage
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.utils.extensions.threeDigitsString

@Composable
fun PokemonInfoScreen(
    navController: NavController,
    viewModel: PokemonInfoViewModel
) {
    val state by viewModel.uiState.collectAsState()

    PokeScreen(
        isLoading = state.loadingInfo || state.loadingDescription,
        navController = navController
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .padding(top = 10.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PokemonInfoBox(state, navController)
            Spacer(modifier = Modifier.height(10.dp))
            PokemonDescriptionBox(state.description)
        }
    }
}

@Composable
private fun PokemonInfoBox(
    state: PokemonInfoUiState,
    navController: NavController? = null
) {
    PokeCardBox {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            PokemonImage(
                pokemonId = state.pokemonNumber,
                imageSize = 240,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Text(
                    text = state.pokemonNumber.threeDigitsString()
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = state.pokemonName
                        .replaceFirstChar {
                            it.uppercase()
                        }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            state.pokemonInfo?.let {
                PokemonStats(
                    pokemonInfo = it,
                    onTypeClick = {
                        navController?.navigateToPokemonTypeInfoScreen(
                            it
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun PokemonDescriptionBox(description: String?) {
    description?.let {
        PokeCardBox(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = it,
                fontSize = 14.sp,
                lineHeight = 30.sp,
                modifier = Modifier.padding(20.dp)
            )

        }
    }
}

@Composable
@Preview
fun PreviewPokemonInfoScreen() {
    val state = PokemonInfoUiState(
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
        ),
        pokemonName = "Charizard",
        pokemonNumber = 7,
        description = "This is a not too long description"
    )

    PokedexComposeTheme {
        PokeScreen {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                PokemonInfoBox(state)
                Spacer(modifier = Modifier.height(10.dp))
                PokemonDescriptionBox(state.description)
            }
        }
    }
}