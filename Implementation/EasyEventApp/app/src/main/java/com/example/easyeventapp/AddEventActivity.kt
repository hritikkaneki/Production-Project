package com.example.easyeventapp



import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.easyeventapp.data.AddEventData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_event.*


class AddEventActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        val submitEvent = findViewById<Button>(R.id.submitEvent)

        submitEvent.setOnClickListener() {

            saveEventData()

        }

    }

    private fun saveEventData() {

        val uid =  FirebaseAuth.getInstance().uid ?: ""
        val ref =FirebaseDatabase.getInstance().getReference("/Users/$uid")
        val eventData = AddEventData(
            uid,
            eventType.text.toString(),
            addEventDescription.text.toString(),
            eventDate.text.toString(),
            eventTime.text.toString(),
            eventVenue.text.toString(),
            eventParticipants.text.toString()

        )




        if (eventType == null || addEventDescription == null || eventDate == null || eventTime == null || eventVenue == null || eventParticipants == null) {
            Toast.makeText(
                this,
                "PLease check if you have correctly filled the form",
                Toast.LENGTH_SHORT
            ).show()

        } else {

            ref.child(eventType.text.toString()).setValue(eventData)
                .addOnCompleteListener {
                    Toast.makeText(
                        this,
                        "Your Event has been successfully added",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(this, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)




                }.addOnFailureListener {
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()

                }

        }

    }

    override fun onBackPressed() {


        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)

        //super.onBackPressed()
    }


}


