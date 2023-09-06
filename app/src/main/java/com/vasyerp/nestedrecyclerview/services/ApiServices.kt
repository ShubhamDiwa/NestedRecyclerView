package com.vasyerp.nestedrecyclerview.services
import com.vasyerp.nestedrecyclerview.MovieDto.PopularMovies
import com.vasyerp.nestedrecyclerview.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiServices {

    @GET("3/movie/popular")
   suspend fun getMovie(@Header("Authorization") token: String):retrofit2.Response<PopularMovies>


}