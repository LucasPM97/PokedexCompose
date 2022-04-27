package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lucas.pokedexcompose.data.models.PokemonInfoEntry
import com.lucas.pokedexcompose.ui.composables.PokeCardBox
import com.lucas.pokedexcompose.ui.composables.PokemonImage
import com.lucas.pokedexcompose.ui.navigateToPokemonTypeInfoScreen
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.utils.extensions.threeDigitsString

@Composable
fun PokemonInfoBox(
    state: PokemonInfoUiState,
    maleGender: Boolean,
    navController: NavController? = null,
) {
    PokeCardBox {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PokemonImage(
                pokemonId = state.pokemonNumber,
                imageSize = 240,
                genderMale = maleGender
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
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
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    imageVector = if (maleGender) Icons.Filled.Male
                    else Icons.Filled.Female,
                    contentDescription = "",
                    tint = Color.Black
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
@Preview
fun PreviewPokemonInfoBox() {

    val state = PokemonInfoUiState(
        pokemonNumber = 6,
        pokemonName = "Charizard",
        pokemonInfo = PokemonInfoEntry(
            height = 1.7f,
            weight = 20f,
            name = "Charizard",
            types = listOf(
                com.lucas.pokedexcompose.data.remote.responses.TypeInfo(
                    "fire", ""
                ),
                com.lucas.pokedexcompose.data.remote.responses.TypeInfo(
                    "flying", ""
                )
            )
        )
    )

    PokedexComposeTheme {
        PokemonInfoBox(
            state = state,
            maleGender = true
        )
    }
}