package com.lucas.pokedexcompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucas.pokedexcompose.data.remote.PokemonDataSource
import com.lucas.pokedexcompose.data.remote.PokemonRetrofitBuilder
import com.lucas.pokedexcompose.data.repositories.PokemonRepository
import com.lucas.pokedexcompose.ui.pokemonInfo.PokemonInfoViewModel
import com.lucas.pokedexcompose.ui.pokemonList.PokemonListViewModel
import java.lang.Exception

enum class ViewModels {
    PokemonList,
}

class PokemonViewModelFactory(val viewModelType: ViewModels) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val repository = PokemonRepository(
            PokemonDataSource(
                PokemonRetrofitBuilder.pokeApi
            )
        )

        val viewModel = when (viewModelType) {
            ViewModels.PokemonList -> PokemonListViewModel(repository)
        }

        return viewModel as T
    }
}

class PokemonInfoViewModelFactory(
    private val pokemonNumber: Int,
    private val pokemonName: String
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = PokemonRepository(
            PokemonDataSource(
                PokemonRetrofitBuilder.pokeApi
            )
        )

        return PokemonInfoViewModel(
            repository = repository,
            pokemonNumber = pokemonNumber,
            pokemonName = pokemonName
        ) as T
    }
}