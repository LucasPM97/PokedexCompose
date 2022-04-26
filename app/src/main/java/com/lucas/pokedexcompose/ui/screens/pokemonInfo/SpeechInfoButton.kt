package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.VolumeUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.pokedexcompose.data.remote.responses.TypeInfo
import com.lucas.pokedexcompose.ui.theme.PokedexComposeTheme
import java.util.*

@Composable
fun SpeechInfoButton(
    state: PokemonInfoUiState
) {

    val context = LocalContext.current

    var speech by remember {
        mutableStateOf<TextToSpeech?>(
            null
        )
    }

    LaunchedEffect(Unit) {
        speech = TextToSpeech(
            context
        ) { status ->
            if (status == TextToSpeech.SUCCESS) {
                // set US English as language for tts
                val result = speech?.setLanguage(Locale.US)

                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "The Language specified is not supported!")
                }

            } else {
                Log.e("TTS", "Initilization Failed!")
            }
        }
    }

    val textToSpeech = "${state.pokemonName}. " +
            getPokemonTypeText(state.pokemonInfo!!.types) +
            (state.description ?: "")

    IconButton(
        modifier = Modifier.size(40.dp),
        onClick = {
            speech!!.speak(textToSpeech, TextToSpeech.QUEUE_FLUSH, null, "")
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
//        SpeechInfoButton()
    }
}