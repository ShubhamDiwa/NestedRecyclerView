package com.vasyerp.nestedrecyclerview.MovieDto

data class PopularMovies(
    val page:Int,
    val results:ArrayList<ResultsDto>,
    val totalPages:Int,
    val totalresults:Int
)
