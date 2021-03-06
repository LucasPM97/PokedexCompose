package com.lucas.pokedexcompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucas.pokedexcompose.data.remote.PokemonDataSource
import com.lucas.pokedexcompose.data.remote.PokemonRetrofitBuilder
import com.lucas.pokedexcompose.data.repositories.PokemonRepository
import com.lucas.pokedexcompose.ui.screens.pokemonInfo.PokemonInfoViewModel
import com.lucas.pokedexcompose.ui.screens.pokemonList.PokemonListViewModel
import com.lucas.pokedexcompose.ui.screens.pokemonTypeInfo.PokemonTypeInfoViewModel

enum class ViewModels {
    PokemonList,
}

private fun getRepository() = PokemonRepository(
    PokemonDataSource(
        PokemonRetrofitBuilder.pokeApi
    )
)


class PokemonViewModelFactory(val viewModelType: ViewModels) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val repository = getRepository()

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
        val repository = getRepository()

        return PokemonInfoViewModel(
            repository = repository,
            pokemonNumber = pokemonNumber,
            pokemonName = pokemonName
        ) as T
    }
}

class PokemonTypeInfoViewModelFactory(
    private val pokemonTypeName: String
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = getRepository()

        return PokemonTypeInfoViewModel(
            repository = repository,
            pokemonTypeName = pokemonTypeName
        ) as T
    }
}