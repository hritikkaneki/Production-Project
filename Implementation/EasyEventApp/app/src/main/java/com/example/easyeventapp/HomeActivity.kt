package com.example.easyeventapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.easyeventapp.fragments.CategoryFragment
import com.example.easyeventapp.fragments.HomeFragment
import com.example.easyeventapp.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth


class HomeActivity : AppCompatActivity() {


    private lateinit var navController: NavController
    private lateinit var  venueRecyclerView: RecyclerView
    private lateinit var  venueArraylist : ArrayList<featured_venue_data>
    lateinit var imageId : Array<Int>
    lateinit var title : Array<String>
    lateinit var description: Array<String>

    private val homeFragment = HomeFragment()
    private val categoryFragment = CategoryFragment()
    private val profileFragment = ProfileFragment()


    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)




        verifyUserIsLoggedIn()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        navController =navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        setupWithNavController(bottomNavigationView,navController)







        }

    override fun onBackPressed() {
        //super.onBackPressed()
    }


    private fun verifyUserIsLoggedIn(){
        val uid = FirebaseAuth.getInstance().uid
        if(uid==null){
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

    }



}