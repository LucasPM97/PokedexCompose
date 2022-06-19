package com.lucas.pokedexcompose.ui.screens.pokemonTypeInfo

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.pokedexcompose.R
import com.lucas.pokedexcompose.data.models.PokemonListEntry
import com.lucas.pokedexcompose.data.models.PokemonTypeInfoEntry
import com.lucas.pokedexcompose.data.remote.responses.Response
import com.lucas.pokedexcompose.data.repositories.IPokemonRepository
import com.lucas.pokedexcompose.utils.extensions.getPokemonNumberFromUrl
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonTypeInfoViewModel(
    private val repository: IPokemonRepository,
    pokemonTypeName: String
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        PokemonTypeInfoUiState(
            pokemonTypeName = pokemonTypeName,
        )
    )
    val uiState = _uiState.asStateFlow()

    private var job: Job? = null

    init {
        getPokemonTypeInfo()
    }

    private fun getPokemonTypeInfo() {
        if (uiState.value.loading) return

        _uiState.update {
            it.copy(
                loading = true
            )
        }

        job?.cancel()
        job = viewModelScope.launch {
            var response =
                repository.getPokemonTypeInfo(pokemonType = _uiState.value.pokemonTypeName)
            when (response) {
                is Response.Success -> {
                    response.data?.let { data ->

                        val pokemonTypeInfo = PokemonTypeInfoEntry(
                            damageRelations = data.damageRelations,
                            name = data.name,
                            pokemons = data.pokemon.map {

                                PokemonListEntry(
                                    pokemonName = it.pokemon.name,
                                    number = it.pokemon.url.getPokemonNumberFromUrl()
                                )
                            }
                        )

                        _uiState.update {
                            it.copy(
                                pokemonTypeInfo = pokemonTypeInfo
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
                    loading = false
                )
            }
        }
    }
}

data class PokemonTypeInfoUiState(
    val pokemonTypeName: String,
    val pokemonTypeInfo: PokemonTypeInfoEntry? = null,
    val loading: Boolean = false,
    @StringRes val errorStringId: Int? = null

)