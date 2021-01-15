package com.ageen.pokemvvm.service


import retrofit2.Call
import com.ageen.pokemvvm.model.PokeApiResponse
import com.ageen.pokemvvm.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {
    
    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id") id: Int): Call<Pokemon>

    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int, 
                       @Query("offset") offset: Int): Call<PokeApiResponse>
    
}