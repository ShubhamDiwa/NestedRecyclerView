package com.vasyerp.nestedrecyclerview.MovieDto

data class PopularMovies<T>(
    val page:Int,
    val results:ArrayList<T>,
    val totalPages:Int,
    val totalresults:Int
)
