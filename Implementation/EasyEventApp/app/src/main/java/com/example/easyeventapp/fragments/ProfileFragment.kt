package com.example.easyeventapp.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.easyeventapp.R
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*



class ProfileFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        return view



    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
//        when(view?.id){
//            R.id.profileSelectButton ->{
//                val intent = Intent(Intent.ACTION_PICK)
//                intent.type="image/*"
//                startActivity(intent)
//
//
//            }
//        }
    }

    fun profileSelect(view: View) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent, 0)
        Log.d("main", "Picture Selected 1")

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d("main", "Picture Selected")

        if(requestCode==0 && requestCode==Activity.RESULT_OK && data != null){

            Log.d("main", "Picture Selected")

            /*val uri =data.data
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)*/

        }
    }




}
