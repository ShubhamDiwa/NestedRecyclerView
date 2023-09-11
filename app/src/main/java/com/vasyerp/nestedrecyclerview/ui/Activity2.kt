package com.vasyerp.nestedrecyclerview.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.vasyerp.nestedrecyclerview.MovieDto.MoviesVO
import com.vasyerp.nestedrecyclerview.MovieDto.PopularMovies
import com.vasyerp.nestedrecyclerview.MovieDto.ResultsDto
import com.vasyerp.nestedrecyclerview.adapter.CommonAdapter
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

    private var MovieList: ArrayList<PopularMovies<ResultsDto>> = arrayListOf()
    private var PosterList: ArrayList<ResultsDto> = arrayListOf()

    private lateinit var madapter: MovieListAdapter
    private lateinit var Cadapter: CommonAdapter
    private lateinit var Podapater: CommonAdapter

    private var CoList: ArrayList<PopularMovies<MoviesVO>> = arrayListOf()
    private var PoList: ArrayList<PopularMovies<MoviesVO>> = arrayListOf()

    private var Air: ArrayList<MoviesVO> = arrayListOf()
    private var Top: ArrayList<MoviesVO> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel()
        inialiseAdapter()

    }

    private fun inialiseAdapter() {
        madapter = MovieListAdapter(this, MovieList)
        binding.rvMain.adapter = madapter
        MovieList.add(PopularMovies(1, PosterList, 39928, 798558))

        Cadapter = CommonAdapter(this, CoList)
        binding.rvMain.adapter = Cadapter
        CoList.add(PopularMovies(1, Air, 39928, 798558))

        Podapater = CommonAdapter(this, PoList)
        binding.rvMain.adapter = Cadapter
        PoList.add(PopularMovies(1, Top, 39928, 798558))
    }

    private fun viewModel() {
        mainViewModel.res.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data.let { it ->
                        if (it?.results?.isNotEmpty() == true) {
                            it.results.toString()
                            PosterList.addAll(it.results)
                            madapter.notifyDataSetChanged()


                            Log.e("TAGShubha", "viewModel:${PosterList} ")
                        }
                    }
                }

                else -> {}
            }
        }

        mainViewModel.air
            .observe(this) {
                when (it.status) {
                    Status.SUCCESS -> {
                        it.data.let {
                            if (it?.results?.isNotEmpty() == true) {
                                it?.results.toString()
                                Air.addAll(it.results)
                                Cadapter.notifyDataSetChanged()
                                Log.e("TAGShubham", "viewModel:${Air} ")
                            }
                        }
                    }

                    else -> {}
                }
            }

        mainViewModel.top.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data.let {
                        if (it?.results?.isNotEmpty() == true) {
                            Top.addAll(it.results)
                            it.results.toString()
                            Podapater.notifyDataSetChanged()
                            Log.e("TAGShubham", "viewModel: ${Top}")
                        }
                    }
                }

                else -> {}
            }
        }
    }


}