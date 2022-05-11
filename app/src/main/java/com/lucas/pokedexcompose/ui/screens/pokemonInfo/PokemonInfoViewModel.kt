package com.lucas.pokedexcompose.ui.screens.pokemonInfo

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.pokedexcompose.R
import com.lucas.pokedexcompose.data.models.HabitatTypes
import com.lucas.pokedexcompose.data.models.PokemonInfoEntry
import com.lucas.pokedexcompose.data.models.PokemonSpeciesEntry
import com.lucas.pokedexcompose.data.remote.responses.Response
import com.lucas.pokedexcompose.data.repositories.IPokemonRepository
import com.lucas.pokedexcompose.utils.extensions.getPokemonNumberFromUrl
import com.lucas.pokedexcompose.utils.extensions.removeEndLineEntries
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonInfoViewModel(
    private val repository: IPokemonRepository,
    pokemonNumber: Int,
    pokemonName: String
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        PokemonInfoUiState(
            pokemonName = pokemonName,
            pokemonNumber = pokemonNumber
        )
    )
    val uiState = _uiState.asStateFlow()

    private var getPokemonInfoJob: Job? = null
    private var getPokemonDescriptionJob: Job? = null

    init {
        getPokemonInfo()
        getPokemonSpeciesInfo()
    }

    private fun getPokemonInfo() {
        if (uiState.value.loadingInfo) return

        _uiState.update {
            it.copy(
                loadingInfo = true
            )
        }

        getPokemonInfoJob?.cancel()
        getPokemonInfoJob = viewModelScope.launch {
            var response = repository.getPokemonInfo(pokemonName = _uiState.value.pokemonName)
            when (response) {
                is Response.Success -> {

                    response.data?.let { data ->
                        val pokemonInfo = PokemonInfoEntry(
                            height = data.height.toFloat() / 10,
                            weight = data.weight.toFloat() / 10,
                            name = data.name,
                            types = data.types.map {
                                it.type
                            }
                        )
                        _uiState.update {
                            it.copy(
                                pokemonInfo = pokemonInfo
                            )
                        }
                    }
                }
                is Response.Error -> {
                    _uiState.update {
                        it.copy(
                            errorStringId = R.string.error_loading_pokemon_list
                        )
                    }
                }
            }

            _uiState.update {
                it.copy(
                    loadingInfo = false
                )
            }
        }
    }

    private fun getPokemonSpeciesInfo() {
        if (uiState.value.loadingSpeciesInfo) return

        _uiState.update {
            it.copy(
                loadingSpeciesInfo = true
            )
        }

        getPokemonDescriptionJob?.cancel()
        getPokemonDescriptionJob = viewModelScope.launch {

            val response =
                repository.getPokemonDescription(pokemonName = _uiState.value.pokemonName)

            when (response) {

                is Response.Success -> {
                    response.data?.let { data ->
                        val flavorText = data.flavorTextEntries.firstOrNull {
                            it.language.name == "en"
                        }

                        val description: String =
                            flavorText?.flavorText?.removeEndLineEntries()
                                ?: "This pokemon has no description"


                        _uiState.update {
                            it.copy(
                                speciesInfo = PokemonSpeciesEntry(
                                    description = description,
                                    habitat = HabitatTypes.values().firstOrNull { habitatType ->
                                        habitatType.name.lowercase() == data.habitat?.name?.replace(
                                            "-",
                                            ""
                                        )
                                    },
                                    evolvesFromName = data.evolvesFrom?.name,
                                    evolvesFromNumber = data.evolvesFrom?.url?.getPokemonNumberFromUrl(),
                                    hasGenderDifferences = data.hasGenderDifferences,
                                    isLegendary = data.isLegendary,
                                    isMythical = data.isMythical,
                                    captureRate = data.captureRate
                                )
                            )
                        }
                    }
                }

                is Response.Error -> {
                    _uiState.update {
                        it.copy(
                            errorStringId = R.string.error_loading_pokemon_list
                        )
                    }
                }

            }


            _uiState.update {
                it.copy(
                    loadingSpeciesInfo = false
                )
            }
        }
    }

}

data class PokemonInfoUiState(
    val pokemonNumber: Int,
    val pokemonName: String,
    val loadingInfo: Boolean = false,
    val pokemonInfo: PokemonInfoEntry? = null,
    val loadingSpeciesInfo: Boolean = false,
    val speciesInfo: PokemonSpeciesEntry? = null,
    @StringRes val errorStringId: Int? = null

)