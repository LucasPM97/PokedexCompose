package com.lucas.pokedexcompose.data.remote.responses

import com.google.gson.annotations.SerializedName

data class PokemonSpeciesResponse(
    @SerializedName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>,
    @SerializedName("capture_rate") val captureRate: Int,
    @SerializedName("evolves_from_species") val evolvesFrom: EvolvesFromSpecies?,
    val habitat: Habitat?,
    @SerializedName("has_gender_differences") val hasGenderDifferences: Boolean,
    @SerializedName("is_legendary") val isLegendary: Boolean,
    @SerializedName("is_mythical") val isMythical: Boolean
)