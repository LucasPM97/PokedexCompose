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
                getEvolutionFromText(state.speciesInfo?.evolvesFromName) +
                getPokemonTypeText(
                    state.pokemonInfo?.types,
                    state.speciesInfo?.isLegendary
                ) +
                getDescriptionText(state.speciesInfo?.description) +
                getEasyToCaptureText(state.speciesInfo?.captureRate) +
                getHabitatText(state.speciesInfo?.habitatName)

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

fun getEasyToCaptureText(captureRate: Int?): String {
    return when {
        captureRate == null -> ""
        captureRate > 200 ->
            "It is gentle and easy to capture. A perfect target for a beginner pokemon trainer to test its Pokemon's skills"
        else -> ""
    } + ". "
}

fun getEvolutionFromText(evolvesFrom: String?): String {
    return if (evolvesFrom == null) ""
    else "Evolved form of ${
        evolvesFrom.replaceFirstChar {
            it.uppercase()
        }
    }. "
}

fun getIsLegendaryPokemonText(isLegendary: Boolean?): String {
    return if (isLegendary == true) "legendary " else ""
}

fun getHabitatText(habitat: String?): String {
    return if (habitat == null) ""
    else if (habitat == "rare")
        "Its habitat is unknown. "
    else "It is seems at ${habitat}s. "
}

fun getPokemonTypeText(
    types: List<TypeInfo>?,
    isLegendary: Boolean?
): String {
    var pokemonTypeText = ""

    types?.let {
        types.forEachIndexed { index, typeInfo ->
            if (index == 0) {
                pokemonTypeText += typeInfo.name
            } else if (index == types.lastIndex) {
                pokemonTypeText += "and ${typeInfo.name}"
            }
            pokemonTypeText += " "
        }
    }
    pokemonTypeText += getIsLegendaryPokemonText(isLegendary)
    pokemonTypeText += "pokemon. "

    return pokemonTypeText
}

fun getDescriptionText(description: String?): String {
    if (description == null) return ""

    return "${description} "

}

@Composable
@Preview
fun PreviewSpeechInfoButton() {
    PokedexComposeTheme {
        SpeechInfoButton()
    }
}