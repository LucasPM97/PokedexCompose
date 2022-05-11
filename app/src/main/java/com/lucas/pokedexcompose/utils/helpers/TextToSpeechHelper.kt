package com.lucas.pokedexcompose.utils.helpers

import com.lucas.pokedexcompose.data.models.PokemonInfoEntry
import com.lucas.pokedexcompose.data.models.PokemonSpeciesEntry
import com.lucas.pokedexcompose.data.remote.responses.TypeInfo

object TextToSpeechHelper {
    fun getPokemonInfoTextToSpeech(
        pokemonName: String,
        pokemonInfo: PokemonInfoEntry?,
        speciesInfo: PokemonSpeciesEntry?
    ): String {
        return "${pokemonName}. " +
                getEvolutionFromText(speciesInfo?.evolvesFromName) +
                getPokemonTypeText(
                    pokemonInfo?.types,
                    speciesInfo?.isLegendary,
                    speciesInfo?.isMythical
                ) +
                getDescriptionText(speciesInfo?.description) +
                getEasyToCaptureText(speciesInfo?.captureRate) +
                getHabitatText(speciesInfo?.habitat.toString())
    }


    private fun getEasyToCaptureText(captureRate: Int?): String {
        return when {
            captureRate == null -> ""
            captureRate > 200 ->
                "It is gentle and easy to capture. A perfect target for a beginner pokemon trainer to test its Pokemon's skills. "
            else -> ""
        }
    }

    private fun getEvolutionFromText(evolvesFrom: String?): String {
        return if (evolvesFrom == null) ""
        else "Evolved form of ${
            evolvesFrom.replaceFirstChar {
                it.uppercase()
            }
        }. "
    }

    private fun getIsLegendaryPokemonText(
        isLegendary: Boolean?,
        isMythical: Boolean?
    ): String {
        return when {
            isLegendary == true -> "legendary "
            isMythical == true -> "mythical "
            else -> ""
        }
    }

    private fun getHabitatText(habitat: String?): String {
        return if (habitat == null) ""
        else if (habitat == "rare")
            "Its habitat is unknown. "
        else "It is seems at ${habitat}s. "
    }

    private fun getPokemonTypeText(
        types: List<TypeInfo>?,
        isLegendary: Boolean?,
        isMythical: Boolean?
    ): String {
        var pokemonTypeText = ""
        pokemonTypeText += getIsLegendaryPokemonText(isLegendary, isMythical)

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
        pokemonTypeText += "pokemon. "

        return pokemonTypeText
    }

    private fun getDescriptionText(description: String?): String {
        if (description == null) return ""

        return "${description} "

    }
}
