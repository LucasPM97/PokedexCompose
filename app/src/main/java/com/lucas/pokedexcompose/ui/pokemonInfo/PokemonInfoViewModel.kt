package com.lucas.pokedexcompose.ui.pokemonInfo

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.pokedexcompose.R
import com.lucas.pokedexcompose.data.models.PokemonListEntry
import com.lucas.pokedexcompose.data.remote.responses.PokemonInfo
import com.lucas.pokedexcompose.data.remote.responses.Response
import com.lucas.pokedexcompose.data.repositories.IPokemonRepository
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
        getPokemonDescription()
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

                    response.data?.let { pokemonInfo ->
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

    private fun getPokemonDescription() {
        if (uiState.value.loadingDescription) return

        _uiState.update {
            it.copy(
                loadingDescription = true
            )
        }

        getPokemonDescriptionJob?.cancel()
        getPokemonDescriptionJob = viewModelScope.launch {
            _uiState.update {
                it.copy(
                    loadingDescription = false
                )
            }
        }
    }

}

data class PokemonInfoUiState(
    val pokemonNumber: Int,
    val pokemonName: String,
    val loadingInfo: Boolean = false,
    val loadingDescription: Boolean = false,
    val pokemonInfo: PokemonInfo? = null,
    @StringRes val errorStringId: Int? = null

)