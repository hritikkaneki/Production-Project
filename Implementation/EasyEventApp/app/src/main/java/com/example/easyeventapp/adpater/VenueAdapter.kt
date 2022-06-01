package com.example.easyeventapp.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.easyeventapp.R
import com.example.easyeventapp.featured_venue_data


class VenueAdapter(private val  venueList: ArrayList<featured_venue_data>) :
    Adapter<VenueAdapter.VenueViewHolder>() {

    class VenueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val featuredImage : ImageView = itemView.findViewById(R.id.featured_image)
        val featuredTitle : TextView = itemView.findViewById(R.id.featured_title)
        val featuredDescription : TextView = itemView.findViewById(R.id.featured_desc)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueViewHolder {


        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.featured_cardview_design, parent, false)
        return VenueViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VenueViewHolder, position: Int) {

        val currentItem = venueList[position]
        holder.featuredImage.setImageResource(currentItem.image)
        holder.featuredTitle.text=currentItem.title
        holder.featuredDescription.text=currentItem.description

    }

    override fun getItemCount(): Int {


        return venueList.size
    }


}