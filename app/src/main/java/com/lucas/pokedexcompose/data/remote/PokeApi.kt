package com.lucas.pokedexcompose.data.remote

import com.lucas.pokedexcompose.data.remote.responses.PokemonInfo
import com.lucas.pokedexcompose.data.remote.responses.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): PokemonInfo
}