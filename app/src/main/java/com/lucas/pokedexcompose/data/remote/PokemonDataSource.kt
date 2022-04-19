package com.lucas.pokedexcompose.data.remote

import com.lucas.pokedexcompose.data.remote.responses.PokemonDescriptionResponse
import com.lucas.pokedexcompose.data.remote.responses.PokemonInfo
import com.lucas.pokedexcompose.data.remote.responses.PokemonListResponse
import com.lucas.pokedexcompose.data.remote.responses.PokemonTypeInfo

class PokemonDataSource(
    private val api: PokeApi
) : IPokemonDataSource {
    override suspend fun getPokemonListData(
        limit: Int,
        offset: Int
    ): PokemonListResponse {
        return api.getPokemonList(limit, offset)
    }

    override suspend fun getPokemonInfoData(pokemonName: String): PokemonInfo {
        return api.getPokemonInfo(pokemonName)
    }

    override suspend fun getPokemonDescriptionData(pokemonName: String): PokemonDescriptionResponse {
        return api.getPokemonDescription(pokemonName)
    }

    override suspend fun getPokemonTypeInfoData(pokemonType: String): PokemonTypeInfo {
        return api.getPokemonTypeInfo(pokemonType)
    }
}

interface IPokemonDataSource {
    suspend fun getPokemonListData(limit: Int, offset: Int): PokemonListResponse
    suspend fun getPokemonInfoData(pokemonName: String): PokemonInfo
    suspend fun getPokemonDescriptionData(pokemonName: String): PokemonDescriptionResponse
    suspend fun getPokemonTypeInfoData(pokemonType: String): PokemonTypeInfo
}