package com.example.easyeventapp

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.editTextEmail
import kotlinx.android.synthetic.main.activity_sign_up.editTextPassword

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val newUser = findViewById<TextView>(R.id.newUser)
        newUser.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }


        val login = findViewById<Button>(R.id.cirLoginButton)
        login.setOnClickListener {

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val role = editTextRole.text.toString()

            if (role .equals("client", ignoreCase = true)) {

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Main", "signInWithEmail:success")
                        val user = auth.currentUser

                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Main", "signInWithEmail:failure", it.exception)
                        Toast.makeText(
                            baseContext, "Login failed.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                }

            } else if(role .equals("admin", ignoreCase = true)) {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Main", "signInWithEmail:success")
                        val user = auth.currentUser

                        val intent = Intent(this, AdminHomeActivity::class.java)
                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Main", "signInWithEmail:failure", it.exception)
                        Toast.makeText(
                            baseContext, "Login failed.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }

            }


        }
    }
}