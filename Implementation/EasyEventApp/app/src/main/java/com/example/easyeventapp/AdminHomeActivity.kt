package com.example.easyeventapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyeventapp.data.AddEventData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_admin_home.*

class AdminHomeActivity : AppCompatActivity(){

    private val EventViewFragment: Context?= null



    private lateinit var dbRef : DatabaseReference
    private lateinit var eventRecyclerView : RecyclerView
    private lateinit var  eventArrayList : ArrayList<AddEventData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)

        eventViewAdapter()

        signOut.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            Activity().finish()
        }



    }

    private fun eventViewAdapter() {

        eventRecyclerView = findViewById<RecyclerView>(R.id.eventRecycler)
        eventRecyclerView.layoutManager = LinearLayoutManager(this)
        eventRecyclerView.setHasFixedSize(true)
        eventRecyclerView.layoutManager = LinearLayoutManager(EventViewFragment)
        eventArrayList = arrayListOf<AddEventData>()
        getEventData()






    }

    private fun getEventData() {
        val uid = FirebaseAuth.getInstance().uid ?: ""
        dbRef = FirebaseDatabase.getInstance().getReference("Users/$uid")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for(eventSnapshot in snapshot.children){
                        var event = eventSnapshot.getValue(AddEventData::class.java)
                        eventArrayList.add(event!!)
                    }
                    eventRecyclerView.adapter =
                        com.example.easyeventapp.adpater.EventViewAdapter(eventArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


    }
}