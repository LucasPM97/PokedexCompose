package com.lucas.pokedexcompose.data.remote

import com.lucas.pokedexcompose.data.remote.responses.PokemonDescriptionResponse
import com.lucas.pokedexcompose.data.remote.responses.PokemonInfo
import com.lucas.pokedexcompose.data.remote.responses.PokemonListResponse
import com.lucas.pokedexcompose.data.remote.responses.PokemonTypeInfo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponse

    @GET("type/{type}")
    suspend fun getPokemonTypeInfo(
        @Path("type") pokemonType: String
    ): PokemonTypeInfo

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): PokemonInfo

    @GET("pokemon-species/{name}")
    suspend fun getPokemonDescription(
        @Path("name") pokemonName: String
    ): PokemonDescriptionResponse
}