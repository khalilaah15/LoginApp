package com.example.ukl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var email = findViewById<EditText>(R.id.email)
        var loginbtn = findViewById<Button>(R.id.loginbtn)

        loginbtn.setOnClickListener {
            val strEmail = email.text.toString()
            val intent = Intent(this, ActivityLogin::class.java)
            intent.putExtra("email", strEmail)
            startActivity(intent)
        }


        }
    }
