package com.vasyerp.nestedrecyclerview.services

import com.vasyerp.nestedrecyclerview.MovieDto.MoviesVO
import com.vasyerp.nestedrecyclerview.MovieDto.PopularMovies
import com.vasyerp.nestedrecyclerview.MovieDto.ResultsDto
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiServices {

    @GET("3/movie/popular")
    suspend fun getMovie(@Header("Authorization") token: String): retrofit2.Response<PopularMovies<ResultsDto>>

    @GET("/3/tv/top_rated")
    suspend fun getTopRated(@Header("Authorization") token: String): retrofit2.Response<PopularMovies<MoviesVO>>
    @GET("3/tv/on_the_air")
    suspend fun getOnAir(@Header("Authorization")token: String):retrofit2.Response<PopularMovies<MoviesVO>>


}