package com.example.easyeventapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.easyeventapp.data.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUp : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding =
        setContentView(R.layout.activity_sign_up)

        val loginUser = findViewById<TextView>(R.id.loginUser)
        loginUser.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        performRegister()

        val male = findViewById<RadioButton>(R.id.maleRadio)
        val female =findViewById<RadioButton>(R.id.femaleRadio)
        val otherGender = findViewById<RadioButton>(R.id.otherRadio)

        male.setOnClickListener {

            female.isChecked = false
            otherGender.isChecked = false

        }

        female.setOnClickListener {
            male.isChecked =false
            otherGender.isChecked= false
        }

        otherGender.setOnClickListener {
            male.isChecked =false
            female.isChecked = false
        }


    }


    private fun performRegister() {
        val register = findViewById<Button>(R.id.cirRegistrationButton)
        register.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val phone = editTextMobile.text.toString()
            val name = editTextName.text.toString()
            Log.d("Signup", "Name is: " + name)

            if (email.isEmpty() || password.isEmpty() || phone.isEmpty() || name.isEmpty()) {
                Toast.makeText(
                    this,
                    "PLease check if you have correctly submitted the form",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            } else {

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (!it.isSuccessful) {
                            //Log.d("Main", "Successfully created user with uid:")
                            return@addOnCompleteListener
                        }
                        //else if successful
                        Log.d("Main", "Successfully created user with uid: ${it.result.user?.uid}")
                        Log.d("Main", "Successfully created user with uid:")

                        saveUserToDatabase()

                    }
                    .addOnFailureListener {
                        Log.d("Main", "Failed to Create User: ${it.message}")
                        Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                    }

            }

        }

    }

    private fun saveUserToDatabase() {

        Log.d("Main","IM HERE")

        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/Users/$uid")
        val user = User(
            uid,
            editTextName.text.toString(),
            editTextEmail.text.toString(),
            editTextMobile.text.toString(),
            editTextPassword.text.toString()




        )


        Log.d("Main","HEllooo")



            ref.child(uid).setValue(user).addOnCompleteListener{


                val intent = Intent(this, HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

                Log.d("Main", "1 step closer")
                //Log.d("Main", "1 step closer ${it.message}")
                if(it.isSuccessful){
                    Log.d("Main","Successfully inserted in database")

                }
                else{
                    Toast.makeText(this, "Failed TO Register", Toast.LENGTH_SHORT).show()
                }

            }.addOnFailureListener{
                Log.d("Main", "1 step closer ${it.message}")
                Toast.makeText(this, "Failed TO Register", Toast.LENGTH_SHORT).show()
            }

    }
}

