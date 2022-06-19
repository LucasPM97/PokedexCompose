package com.lucas.pokedexcompose.data.remote

import com.lucas.pokedexcompose.utils.Constans.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRetrofitBuilder {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val pokeApi: PokeApi = getRetrofit().create(PokeApi::class.java)
}