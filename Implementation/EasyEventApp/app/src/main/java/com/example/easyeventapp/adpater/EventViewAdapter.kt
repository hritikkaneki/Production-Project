package com.example.easyeventapp.adpater

import android.content.pm.PackageManager
import android.util.Property
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyeventapp.R
import com.example.easyeventapp.data.AddEventData

class EventViewAdapter(private val eventList: ArrayList<AddEventData>) :

    RecyclerView.Adapter<EventViewAdapter.EventViewHolder>() {



    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



        val eventType: TextView = itemView.findViewById(R.id.tvEventType)
        val eventDescription: TextView = itemView.findViewById(R.id.tvEventDescription)
        val eventDate: TextView = itemView.findViewById(R.id.tvEventDate)
        val eventVenue: TextView = itemView.findViewById(R.id.tvEventVenue)
        val eventTime: TextView = itemView.findViewById(R.id.tvEventTime)
        val eventParticipants: TextView = itemView.findViewById(R.id.tvEventParticipants)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.event_list, parent, false)


        return EventViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {

        val currentItem = eventList[position]
        holder.eventType.text = currentItem.eventType
        holder.eventDescription.text = currentItem.eventDescription
        holder.eventDate.text = currentItem.eventDate
        holder.eventTime.text = currentItem.eventTime
        holder.eventVenue.text = currentItem.eventVenue
        holder.eventParticipants.text = currentItem.eventParticipants





    }

    override fun getItemCount(): Int {

        return eventList.size

    }


}


