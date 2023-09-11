package com.vasyerp.nestedrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vasyerp.nestedrecyclerview.MovieDto.MovieDTO
import com.vasyerp.nestedrecyclerview.MovieDto.PopularMovies
import com.vasyerp.nestedrecyclerview.MovieDto.ResultsDto
import com.vasyerp.nestedrecyclerview.R


class MovieListAdapter(var context: Context, private val mlist: ArrayList<PopularMovies<ResultsDto>>) :
    RecyclerView.Adapter<MovieListAdapter.mViewHolder>() {
    class mViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val childApa = itemview.findViewById<RecyclerView>(R.id.ChildAdapter)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_name_item, parent, false)
        return mViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        val itemModel = mlist[position]
        val childAdapter = ChildAdapter(context, itemModel.results)
        holder.childApa.adapter = childAdapter

    }
}