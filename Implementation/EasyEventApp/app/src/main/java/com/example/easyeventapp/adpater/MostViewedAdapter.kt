package com.example.easyeventapp.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyeventapp.data.MostViewed
import com.example.easyeventapp.R

class MostViewedAdapter(private val mostViewedList: ArrayList<MostViewed>):
    RecyclerView.Adapter<MostViewedAdapter.MVViewHolder>() {
    class MVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mvImage : ImageView = itemView.findViewById(R.id.mv_image)
        val mvTitle : TextView = itemView.findViewById(R.id.mv_title)
        val mvDescription : TextView = itemView.findViewById(R.id.mv_desc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MVViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.most_viewed, parent, false)
        return MVViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MVViewHolder, position: Int) {


        val currentItem = mostViewedList[position]
        holder.mvImage.setImageResource(currentItem.mvImage)
        holder.mvTitle.text=currentItem.mvTitle
        holder.mvDescription.text=currentItem.mvDes

    }

    override fun getItemCount(): Int {
        return mostViewedList.size
    }
}