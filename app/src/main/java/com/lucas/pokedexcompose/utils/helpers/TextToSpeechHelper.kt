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
                    speciesInfo?.isMythical,
                    speciesInfo?.isBaby
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
            isMythical == true -> "mythical "
            isLegendary == true -> "legendary "
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
        isMythical: Boolean?,
        isBaby: Boolean?
    ): String {
        var pokemonTypeText = ""
        pokemonTypeText += getIsLegendaryPokemonText(isLegendary, isMythical)
        pokemonTypeText += getBabyPokemonText(isBaby)

        types?.let {
            types.forEachIndexed { index, typeInfo ->
                pokemonTypeText += getTypeText(index, typeInfo, types)
            }
        }
        pokemonTypeText += "pokemon. "

        return pokemonTypeText
    }

    private fun getTypeText(
        index: Int, typeInfo: TypeInfo, types: List<TypeInfo>
    ): String {
        val pokemonTypeText = if (index == 0)
            typeInfo.name
        else "and ${typeInfo.name}"

        return "$pokemonTypeText "
    }

    private fun getBabyPokemonText(isBaby: Boolean?) = if (isBaby == true) "baby " else ""

    private fun getDescriptionText(description: String?): String {
        if (description == null) return ""

        return "$description "

    }
}
