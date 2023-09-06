package com.vasyerp.nestedrecyclerview.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.vasyerp.nestedrecyclerview.MovieDto.MoviePosterVo
import com.vasyerp.nestedrecyclerview.MovieDto.PopularMovies
import com.vasyerp.nestedrecyclerview.MovieDto.ResultsDto
import com.vasyerp.nestedrecyclerview.adapter.MovieListAdapter
import com.vasyerp.nestedrecyclerview.databinding.Activity2Binding
import com.vasyerp.nestedrecyclerview.utils.Status
import com.vasyerp.nestedrecyclerview.viewModels.MainViewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Activity2 : AppCompatActivity() {

    private val binding: Activity2Binding by lazy {
        Activity2Binding.inflate(layoutInflater)
    }

    private val mainViewModel: MainViewModels by viewModels()

    private var MovieList: ArrayList<ResultsDto> = arrayListOf()
    private var PosterList: ArrayList<MoviePosterVo> = arrayListOf()

    private lateinit var madapter: MovieListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel()

        madapter = MovieListAdapter(this, MovieList)
        binding.rvMain.adapter = madapter

/*

        MovieList.add(MovieDTO("Top-Rated", PosterList))
        MovieList.add(MovieDTO("Popular", PosterList))
        MovieList.add(MovieDTO("Most-Watched", PosterList))
        MovieList.add(MovieDTO("Favourite", PosterList))
        MovieList.add(MovieDTO("Liked", PosterList))
        MovieList.add(MovieDTO("WatchList", PosterList))
*/
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )
        PosterList.add(
            MoviePosterVo(
                "https://images.pexels.com/photos/18026292/pexels-photo-18026292/free-photo-of-moss-on-tree-trunk.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Singhma"
            )
        )

    }

    private fun viewModel() {
        mainViewModel.res.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data.let { it ->

                        if (it?.results?.isNotEmpty() == true) {
                            it.results.toString()
                            MovieList.addAll(it.results)
                            Log.e("TAGShubha", "viewModel:${it.results} ", )
                        }
                    }
                }

                else -> {}
            }
        }
    }
}