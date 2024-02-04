package com.example.pokedex.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonList (val results: List<Pokemon>)

@JsonClass(generateAdapter = true)
data class Pokemon(val name: String, val url: String)