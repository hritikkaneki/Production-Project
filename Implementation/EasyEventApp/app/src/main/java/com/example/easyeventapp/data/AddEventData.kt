package com.example.easyeventapp.data

import com.google.firebase.auth.FirebaseUser

data class AddEventData(
    val uid: String?= "",
    val eventType: String?= "",
    val eventDescription: String?= "",
    val eventDate: String?= "",
    val eventTime: String?= "",
    val eventVenue: String?= "",
    val eventParticipants: String?= ""

)
