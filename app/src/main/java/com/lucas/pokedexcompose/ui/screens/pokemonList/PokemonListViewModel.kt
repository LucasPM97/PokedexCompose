package com.lucas.pokedexcompose.ui.screens.pokemonList

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.pokedexcompose.R
import com.lucas.pokedexcompose.data.models.PokemonListEntry
import com.lucas.pokedexcompose.data.remote.responses.Response
import com.lucas.pokedexcompose.data.repositories.IPokemonRepository
import com.lucas.pokedexcompose.utils.Constans.LIST_LIMIT
import com.lucas.pokedexcompose.utils.extensions.getPokemonNumberFromUrl
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val repository: IPokemonRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        PokemonListUiState(
            loading = false,
            pokemonList = emptyList()
        )
    )
    val uiState = _uiState.asStateFlow()

    private var job: Job? = null

    init {
        loadPokemonListPage()
    }

    fun loadPokemonListPage() {

        if (uiState.value.loading) return

        _uiState.update {
            it.copy(
                loading = true
            )
        }

        job?.cancel()
        job = viewModelScope.launch {

            val response = repository.getPokemonList(LIST_LIMIT, uiState.value.pokemonList.size)

            when (response) {
                is Response.Success -> {

                    val entries: List<PokemonListEntry>? = response.data?.results?.map {
                        PokemonListEntry(
                            it.name,
                            number = it.url.getPokemonNumberFromUrl()
                        )
                    }

                    entries?.let {
                        _uiState.update {
                            it.copy(
                                pokemonList = uiState.value.pokemonList + entries
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

data class PokemonListUiState(
    val pokemonList: List<PokemonListEntry>,
    val loading: Boolean,
    @StringRes val errorStringId: Int? = null
)