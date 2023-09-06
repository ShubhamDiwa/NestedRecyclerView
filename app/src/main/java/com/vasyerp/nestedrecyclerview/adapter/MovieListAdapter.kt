package com.vasyerp.nestedrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vasyerp.nestedrecyclerview.MovieDto.MovieDTO
import com.vasyerp.nestedrecyclerview.R


class MovieListAdapter(var context: Context, private val mlist: ArrayList<MovieDTO>) :
    RecyclerView.Adapter<MovieListAdapter.mViewHolder>() {
    class mViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var titleName = itemview.findViewById<TextView>(R.id.Movie_title)
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
        holder.titleName.text = itemModel.Title
        val childAdapter = ChildAdapter(context, itemModel.Pos)
        holder.childApa.adapter = childAdapter

    }
}