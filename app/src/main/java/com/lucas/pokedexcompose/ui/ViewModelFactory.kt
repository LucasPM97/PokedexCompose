package com.lucas.pokedexcompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucas.pokedexcompose.data.remote.PokemonDataSource
import com.lucas.pokedexcompose.data.remote.PokemonRetrofitBuilder
import com.lucas.pokedexcompose.data.repositories.PokemonRepository
import com.lucas.pokedexcompose.ui.pokemonList.PokemonListViewModel

class PokemonListViewModelFactory() : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonListViewModel(
            PokemonRepository(
                PokemonDataSource(
                    PokemonRetrofitBuilder.pokeApi
                )
            )
        ) as T
    }
}