package com.vasyerp.nestedrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vasyerp.nestedrecyclerview.MovieDto.MoviesVO
import com.vasyerp.nestedrecyclerview.MovieDto.PopularMovies
import com.vasyerp.nestedrecyclerview.R

class CommonAdapter(var context: Context, private val commonList: ArrayList<PopularMovies<MoviesVO>>
) : RecyclerView.Adapter<CommonAdapter.MViewHolder>() {
    class MViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val childApa = itemview.findViewById<RecyclerView>(R.id.ChildAdapter)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_name_item, parent, false)
        return MViewHolder(view)
    }

    override fun getItemCount(): Int {

        return commonList.size
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        val item = commonList[position]
        val childAdapter = CommonChildAdapter(context, item.results)
        holder.childApa.adapter = childAdapter
    }
}
