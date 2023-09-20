package com.example.sharepreference

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val localestrong=getSharedPreferences("user", Context.MODE_PRIVATE)

        val getname=localestrong.getString("username","name NOT Found")
        val getemail=localestrong.getString("useremail","email NOT FOUND")

        val name=findViewById<TextView>(R.id.username)
        val email=findViewById<TextView>(R.id.useremail)

        name.text=getname.toString()
        email.text=getemail.toString()

        Toast.makeText(this, "$getname", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "$getemail", Toast.LENGTH_SHORT).show()
    }
}