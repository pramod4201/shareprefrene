package com.example.sharepreference

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name=findViewById<EditText>(R.id.entername)
        val email=findViewById<EditText>(R.id.enteremail)
        val save=findViewById<Button>(R.id.savebtn)
        val show=findViewById<Button>(R.id.showbtn)

        val localestrong=getSharedPreferences("user",Context.MODE_PRIVATE)

        save.setOnClickListener{
            val editpref=localestrong.edit()
            editpref.putString("username",""+ name.text.toString())
            editpref.putString("useremail",""+ email.text.toString()).apply()
        }
        show.setOnClickListener{
            val getname=localestrong.getString("username","name NOT Found")
            val getemail=localestrong.getString("useremail","email NOT FOUND")
            Toast.makeText(this, "$getname", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "$getemail", Toast.LENGTH_SHORT).show()


            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

    }
}