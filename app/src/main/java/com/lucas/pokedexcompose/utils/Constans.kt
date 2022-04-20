package com.lucas.pokedexcompose.utils

object Constans {
    const val BASE_URL = "https://pokeapi.co/api/v2/"
    const val LIST_LIMIT = 50

    object Screens {
        const val PokemonListScreenName = "pokemon_list"

        const val PokemonInfoScreenName = "pokemon_info"
        object PokemonInfoArguments{
            const val PokemonName = "pokemonName"
            const val PokemonNumber = "number"

        }

        const val PokemonTypeInfoScreenName = "pokemon_type_info"
        object PokemonTypeInfoArguments{
            const val PokemonTypeName = "pokemonTypeName"
        }
    }
}