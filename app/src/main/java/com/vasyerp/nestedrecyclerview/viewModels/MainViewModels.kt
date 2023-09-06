package com.vasyerp.nestedrecyclerview.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vasyerp.nestedrecyclerview.MovieDto.PopularMovies
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

    private val _res = MutableLiveData<Resource<PopularMovies>>()
    val res: LiveData<Resource<PopularMovies>>
        get() = _res


    init {

        getMovies()
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