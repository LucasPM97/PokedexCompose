package com.lucas.pokedexcompose.data.repositories

import com.lucas.pokedexcompose.data.remote.IPokemonDataSource
import com.lucas.pokedexcompose.data.remote.responses.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class PokemonRepository(
    private val dataSource: IPokemonDataSource
) : IPokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): Response<PokemonListResponse> {
        return withContext(Dispatchers.IO) {
            val response = try {
                dataSource.getPokemonListData(limit, offset)
            } catch (e: Exception) {
                return@withContext Response.Error("There was an error trying to get the pokemon list.")
            }

            return@withContext Response.Success(data = response)
        }
    }

    override suspend fun getPokemonInfo(pokemonName: String): Response<PokemonInfo> {
        return withContext(Dispatchers.IO) {
            val response = try {
                dataSource.getPokemonInfoData(pokemonName)
            } catch (e: Exception) {
                return@withContext Response.Error("There was an error trying to get the named pokemon info.")
            }

            return@withContext Response.Success(data = response)
        }
    }

    override suspend fun getPokemonDescription(pokemonName: String): Response<PokemonSpeciesResponse> {
        return withContext(Dispatchers.IO) {
            val response = try {
                dataSource.getPokemonDescriptionData(pokemonName)
            } catch (e: Exception) {
                print(e)
                return@withContext Response.Error("There was an error trying to get the named pokemon info.")
            }

            return@withContext Response.Success(data = response)
        }
    }

    override suspend fun getPokemonTypeInfo(pokemonType: String): Response<PokemonTypeInfo> {
        return withContext(Dispatchers.IO) {
            val response = try {
                dataSource.getPokemonTypeInfoData(pokemonType)
            } catch (e: Exception) {
                return@withContext Response.Error("There was an error trying to get the named pokemon type info.")
            }

            return@withContext Response.Success(data = response)
        }
    }
}

interface IPokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Response<PokemonListResponse>
    suspend fun getPokemonInfo(pokemonName: String): Response<PokemonInfo>
    suspend fun getPokemonDescription(pokemonName: String): Response<PokemonSpeciesResponse>
    suspend fun getPokemonTypeInfo(pokemonType: String): Response<PokemonTypeInfo>
}