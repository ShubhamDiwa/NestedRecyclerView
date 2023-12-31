package com.vasyerp.nestedrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import com.vasyerp.nestedrecyclerview.MovieDto.MoviePosterVo
import com.vasyerp.nestedrecyclerview.MovieDto.ResultsDto
import com.vasyerp.nestedrecyclerview.R
import com.vasyerp.nestedrecyclerview.utils.Constants

class ChildAdapter(var context: Context,private val posterList: ArrayList<ResultsDto>):RecyclerView.Adapter<ChildAdapter.cViewHolder>() {
    class cViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        var  posterimage=itemview.findViewById<ImageView>(R.id.iv_Poster)
        var movieName=itemview.findViewById<TextView>(R.id.movieName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.movie_poster,parent,false)
        return cViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posterList.size
    }

    override fun onBindViewHolder(holder: cViewHolder, position: Int) {
        val  poslist=posterList[position]
        holder.movieName.text=poslist.title
        holder.posterimage.load(Constants.IMAGE_URL+poslist.poster_path){
            placeholder(R.drawable.johnwick).error(R.drawable.free
            )
        }


    }
}