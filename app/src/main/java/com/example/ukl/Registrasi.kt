package com.example.ukl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class Registrasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val view_pager : ViewPager = findViewById(R.id.view_pager)
        val tabs : TabLayout = findViewById(R.id.SignUp)

        view_pager.adapter = ViewPagerAdapter(this, supportFragmentManager)
        tabs.setupWithViewPager(view_pager)
    }
}