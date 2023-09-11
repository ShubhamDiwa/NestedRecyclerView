package com.vasyerp.nestedrecyclerview.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vasyerp.nestedrecyclerview.MovieDto.MoviesVO
import com.vasyerp.nestedrecyclerview.MovieDto.PopularMovies
import com.vasyerp.nestedrecyclerview.MovieDto.ResultsDto
import com.vasyerp.nestedrecyclerview.repo.MoviesListRepo
import com.vasyerp.nestedrecyclerview.utils.NetworkHelper
import com.vasyerp.nestedrecyclerview.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModels @Inject constructor(
    private val repo: MoviesListRepo, private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _res = MutableLiveData<Resource<PopularMovies<ResultsDto>>>()
    private val _top = MutableLiveData<Resource<PopularMovies<MoviesVO>>>()
    private val _air = MutableLiveData<Resource<PopularMovies<MoviesVO>>>()

    val res: LiveData<Resource<PopularMovies<ResultsDto>>>
        get() = _res
    val top: LiveData<Resource<PopularMovies<MoviesVO>>>
        get() = _top
    val air : LiveData<Resource<PopularMovies<MoviesVO>>>
        get() = _air

    init {

        getMovies()
        getTopM()
        getAir()
    }

    private fun getAir() {

    }

    private fun getTopM() = viewModelScope.launch {
        _top.postValue(Resource.loading(null))
        if (networkHelper.isNetworkConnected()) {
            repo.topRate().let {
                if (it.isSuccessful) {
                    _top.postValue(Resource.success(it.body()))
                } else {
                    _top.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }
        } else {
            _top.postValue(Resource.error("No internet Connected", null))

        }

    }

    private fun getMovies() = viewModelScope.launch {
        _res.postValue(Resource.loading(null))
        if (networkHelper.isNetworkConnected()) {
            repo.movie().let {
                if (it.isSuccessful) {
                    _res.postValue(Resource.success(it.body()))

                } else {
                    _res.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }
        } else {
            _res.postValue(Resource.error("No internet Connected", null))
        }


    }

}