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
import com.lucas.pokedexcompose.data.models.HabitatTypes
import com.lucas.pokedexcompose.data.models.PokemonInfoEntry
import com.lucas.pokedexcompose.ui.composables.HabitatIcon
import com.lucas.pokedexcompose.ui.composables.PokeCardBox
import com.lucas.pokedexcompose.ui.composables.PokemonImage
import com.lucas.pokedexcompose.ui.navigateToPokemonTypeInfoScreen
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.utils.extensions.WindowSize
import com.lucas.pokedexcompose.utils.extensions.threeDigitsString

@Composable
fun PokemonInfoBox(
    state: PokemonInfoUiState,
    maleGender: Boolean,
    boxModifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier,
    isCompactWindow: Boolean = true,
    navController: NavController? = null
) {
    PokeCardBox {
        Column(
            modifier = boxModifier
        ) {
            HabitatHeader(state.speciesInfo?.habitat)
            Column(
                modifier = contentModifier,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                PokemonImage(
                    pokemonId = state.pokemonNumber,
                    imageSize = 240,
                    genderMale = maleGender
                )
                if (isCompactWindow) {
                    Spacer(modifier = Modifier.height(20.dp))
                    PokemonData(state, maleGender, navController)
                }
            }
        }
    }
}

@Composable
fun PokemonData(
    state: PokemonInfoUiState,
    maleGender: Boolean,
    navController: NavController?
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
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
        if (state.speciesInfo?.hasGenderDifferences == true) {
            GenderIcon(maleGender)
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    state.pokemonInfo?.let {
        PokeBodyStats(
            height = it.height,
            weight = it.weight
        )
        Spacer(modifier = Modifier.height(20.dp))
        PokemonTypeRow(
            types = it.types,
            itemOnClick = {
                navController?.navigateToPokemonTypeInfoScreen(
                    it
                )
            }
        )
    }
}

@Composable
private fun HabitatHeader(habitat: HabitatTypes?) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        HabitatIcon(
            habitat = habitat,
            size = 50
        )
    }
}

@Composable
private fun GenderIcon(maleGender: Boolean) {
    Icon(
        imageVector = if (maleGender) Icons.Filled.Male
        else Icons.Filled.Female,
        contentDescription = "",
        tint = Color.Black
    )
}


val previewState = PokemonInfoUiState(
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

@Composable
@Preview
fun PreviewPokemonInfoBox() {
    PokedexComposeTheme {
        PokemonInfoBox(
            state = previewState,
            maleGender = true,
            boxModifier = Modifier.fillMaxWidth(),
            contentModifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
@Preview
fun PreviewPokemonPokemonDataBox() {
    PokedexComposeTheme {
        PokeCardBox {
            Column {
                PokemonData(
                    previewState,
                    true,
                    null
                )
            }
        }
    }
}