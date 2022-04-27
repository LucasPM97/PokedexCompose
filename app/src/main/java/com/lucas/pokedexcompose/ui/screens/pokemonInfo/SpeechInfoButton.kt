package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.VolumeUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Row(
        Modifier
            .fillMaxHeight()
            .clickable {
                speech?.speak(
                    textToSpeech,
                    TextToSpeech.QUEUE_FLUSH,
                    null,
                    ""
                )
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            imageVector = Icons.Rounded.VolumeUp,
            contentDescription = "Hear pokemon description",
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Info",
            color = Color.White
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