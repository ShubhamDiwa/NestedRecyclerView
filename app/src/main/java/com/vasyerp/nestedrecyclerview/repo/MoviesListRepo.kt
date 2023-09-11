package com.vasyerp.nestedrecyclerview.repo

import com.vasyerp.nestedrecyclerview.services.ApiServices
import com.vasyerp.nestedrecyclerview.utils.Constants
import javax.inject.Inject

class MoviesListRepo @Inject constructor(private val apiservices: ApiServices) {
    suspend fun movie() = apiservices.getMovie(Constants.Auth)
    suspend fun topRate() = apiservices.getTopRated(Constants.Auth)
    suspend fun onAir() = apiservices.getOnAir(Constants.Auth)
}