package com.example.ukl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginbtn: Button
    private lateinit var registrasi: Button
//    private var title: String = "Lightstick Area"
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        loginbtn = findViewById(R.id.loginbtn)
        registrasi = findViewById(R.id.registrasi)

        loginbtn.setOnClickListener {
            val strEmail = email.text.toString()
            val intent = Intent(this@MainActivity, ActivityLogin::class.java)
            intent.putExtra("email", strEmail)
            startActivity(intent)
        }

        registrasi.setOnClickListener {
            val intent = Intent(this, Registrasi::class.java)
            startActivity(intent)
        }
    }
}
