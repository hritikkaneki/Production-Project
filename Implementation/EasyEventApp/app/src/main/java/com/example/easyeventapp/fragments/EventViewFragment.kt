package com.example.easyeventapp.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyeventapp.AddEventActivity
import com.example.easyeventapp.R
import com.example.easyeventapp.data.AddEventData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.frament_event_view.*


class EventViewFragment : Fragment() {

    private val EventViewFragment: Context?= null

    private lateinit var addEventBtn: TextView
    private lateinit var dbRef : DatabaseReference
    private lateinit var eventRecyclerView : RecyclerView
    private lateinit var  eventArrayList : ArrayList<AddEventData>
    private lateinit var eventOption : TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.frament_event_view, container, false)

        addEventBtn = view.findViewById(R.id.addEventBtn)




        addEventBtn.setOnClickListener {

            requireActivity().startActivity(Intent(activity, AddEventActivity::class.java))
            requireActivity().finish()


        }

        return view




    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        eventViewAdapter()










    }


    private fun eventViewAdapter(){

        eventRecyclerView =eventRecycler
        eventRecyclerView.layoutManager = LinearLayoutManager(activity)
        eventRecyclerView.setHasFixedSize(true)
        eventRecyclerView.layoutManager = LinearLayoutManager(EventViewFragment)
        eventArrayList = arrayListOf<AddEventData>()
        getEventData()




    }

    private fun getEventData() {
        val uid = FirebaseAuth.getInstance().uid ?: ""
        dbRef = FirebaseDatabase.getInstance().getReference("Users/$uid")

        dbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for(eventSnapshot in snapshot.children){
                        val event =eventSnapshot.getValue(AddEventData::class.java)
                        eventArrayList.add(event!!)
                    }
                     eventRecyclerView.adapter = com.example.easyeventapp.adpater.EventViewAdapter(eventArrayList)




                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


    }


}






