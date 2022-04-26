package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.VolumeUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.data.remote.responses.TypeInfo
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun SpeechInfoButton(
    state: PokemonInfoUiState? = null,
    speech: TextToSpeech? = null
) {

    val textToSpeech = if (state == null) ""
    else {
        "${state.pokemonName}. " +
                getPokemonTypeText(state.pokemonInfo?.types ?: emptyList()) +
                (state.description ?: "")
    }

    IconButton(
        modifier = Modifier.size(40.dp),
        onClick = {
            speech?.speak(
                textToSpeech,
                TextToSpeech.QUEUE_FLUSH,
                null,
                ""
            )
        }) {
        Icon(
            imageVector = Icons.Rounded.VolumeUp,
            contentDescription = "Hear pokemon description"
        )
    }
}

fun getPokemonTypeText(
    types: List<TypeInfo>
): String {
    var pokemonTypeText = ""

    if (types.any()) {
        types.forEachIndexed { index, typeInfo ->
            if (index == 0) {
                pokemonTypeText += typeInfo.name
            } else if (index == types.lastIndex) {
                pokemonTypeText += "and ${typeInfo.name}"
            }
            pokemonTypeText += " "
        }
        pokemonTypeText += "pokemon. "
    }

    return pokemonTypeText
}

@Composable
@Preview
fun PreviewSpeechInfoButton() {
    PokedexComposeTheme {
        SpeechInfoButton()
    }
}