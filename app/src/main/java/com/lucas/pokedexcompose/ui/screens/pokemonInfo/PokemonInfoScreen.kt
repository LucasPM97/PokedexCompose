package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lucas.pokedexcompose.data.models.HabitatTypes
import com.lucas.pokedexcompose.data.models.PokemonInfoEntry
import com.lucas.pokedexcompose.data.models.PokemonSpeciesEntry
import com.lucas.pokedexcompose.data.remote.responses.TypeInfo
import com.lucas.pokedexcompose.ui.composables.PokeScreen
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokemonInfoScreen(
    navController: NavController,
    viewModel: PokemonInfoViewModel,
    speech: TextToSpeech? = null
) {
    val state by viewModel.uiState.collectAsState()

    var maleGender by remember {
        mutableStateOf(true)
    }

    PokeScreen(
        isLoading = state.loadingInfo || state.loadingSpeciesInfo,
        navController = navController,
        bottomBarContent = {
            SpeechInfoButton(state, speech)
            GenderButton(state.speciesInfo, !maleGender) {
                maleGender = !maleGender
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .padding(top = 10.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            PokemonInfoBox(
                state = state,
                maleGender = maleGender,
                navController
            )
            Spacer(modifier = Modifier.height(10.dp))
            state.speciesInfo?.let { speciesInfo ->
                PokemonDescriptionBox(state.speciesInfo?.description)
            }
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
        speciesInfo = PokemonSpeciesEntry(
            description = "Spits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally.",
            evolvesFromName = "charmeleon",
            evolvesFromNumber = 5,
            habitat = HabitatTypes.Mountain,
            captureRate = 45,
            hasGenderDifferences = false,
            isLegendary = false,
            isMythical = false,
            isBaby = false
        )
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
                PokemonInfoBox(state, maleGender = true)
                Spacer(modifier = Modifier.height(10.dp))
                PokemonDescriptionBox(state.speciesInfo?.description)
            }
        }
    }
}