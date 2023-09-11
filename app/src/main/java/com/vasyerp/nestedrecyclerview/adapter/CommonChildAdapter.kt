package com.vasyerp.nestedrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.vasyerp.nestedrecyclerview.MovieDto.MoviesVO
import com.vasyerp.nestedrecyclerview.R
import com.vasyerp.nestedrecyclerview.utils.Constants

class CommonChildAdapter(var context: Context, private val topList: ArrayList<MoviesVO>):
    RecyclerView.Adapter<CommonChildAdapter.cViewHolder>() {
    class cViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        var  posterimage=itemview.findViewById<ImageView>(R.id.iv_Poster)
        var movieName=itemview.findViewById<TextView>(R.id.movieName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.movie_poster,parent,false)
        return cViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  topList.size

    }

    override fun onBindViewHolder(holder: cViewHolder, position: Int) {
        val Model=topList[position]
        holder.movieName.text=Model.name
        holder.posterimage.load(Constants.IMAGE_URL+Model.posterPath){
            placeholder(R.drawable.johnwick).error(R.drawable.free
            )
        }
    }
}