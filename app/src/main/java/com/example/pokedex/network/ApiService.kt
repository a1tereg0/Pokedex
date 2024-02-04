package com.example.pokedex.network

import com.example.pokedex.network.models.PokemonList
import retrofit2.http.GET

interface ApiService {
    @GET("pokemon/")
    suspend fun getPokemons(): PokemonList
}