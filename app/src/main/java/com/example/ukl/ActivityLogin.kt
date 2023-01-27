package com.example.ukl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email = findViewById<TextView>(R.id.tvEmail)
        val data = intent.getStringExtra("email").toString()
        email.text=data
    }
}