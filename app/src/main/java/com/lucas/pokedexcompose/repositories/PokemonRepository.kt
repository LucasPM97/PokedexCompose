package com.lucas.pokedexcompose.repositories

import com.lucas.pokedexcompose.data.remote.PokeApi
import com.lucas.pokedexcompose.data.remote.responses.PokemonInfo
import com.lucas.pokedexcompose.data.remote.responses.Response
import com.lucas.pokedexcompose.data.remote.responses.PokemonListResponse
import com.lucas.pokedexcompose.data.remote.responses.PokemonTypeInfo
import java.lang.Exception

class PokemonRepository(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Response<PokemonListResponse> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Response.Error("There was an error trying to get the pokemon list.")
        }

        return Response.Success(data = response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Response<PokemonInfo> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Response.Error("There was an error trying to get the named pokemon info.")
        }

        return Response.Success(data = response)
    }

    suspend fun getPokemonTypeInfo(pokemonType: String): Response<PokemonTypeInfo> {
        val response = try {
            api.getPokemonTypeInfo(pokemonType)
        } catch (e: Exception) {
            return Response.Error("There was an error trying to get the named pokemon type info.")
        }

        return Response.Success(data = response)
    }
}