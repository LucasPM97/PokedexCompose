package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import android.speech.tts.TextToSpeech
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.VolumeUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lucas.pokedexcompose.ui.composables.navigation.BottomBarRowIconButton
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import com.lucas.pokedexcompose.utils.helpers.TextToSpeechHelper

@Composable
fun SpeechInfoButton(
    state: PokemonInfoUiState,
    speech: TextToSpeech? = null
) {

    val textToSpeech = TextToSpeechHelper.getPokemonInfoTextToSpeech(
        pokemonName = state.pokemonName,
        pokemonInfo = state.pokemonInfo,
        speciesInfo = state.speciesInfo
    )
    BottomBarRowIconButton(
        icon = Icons.Rounded.VolumeUp,
        text = "Info"
    ) {
        speech?.speak(
            textToSpeech,
            TextToSpeech.QUEUE_FLUSH,
            null,
            ""
        )
    }
}

@Composable
@Preview
fun PreviewSpeechInfoButton() {
    PokedexComposeTheme {
        SpeechInfoButton(
            state = PokemonInfoUiState(
                pokemonName = "Charizard",
                pokemonNumber = 6
            )
        )
    }
}