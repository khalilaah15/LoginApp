package com.example.ukl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import java.sql.RowId

class Registrasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrasi_fragment)

        val view_pager : ViewPager = findViewById(R.id.view_pager)
        val tabs : TabLayout = findViewById(R.id.tabs)

        view_pager.adapter = ViewPagerAdapter(this, supportFragmentManager)
        tabs.setupWithViewPager(view_pager)
    }

    private fun gantiFragment (
        fragmentManager: FragmentManager, fragment: Fragment, frameId: Int
    ) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment)

        transaction.commit()
    }

    fun tampilMyFriendsFragment() {
        gantiFragment(supportFragmentManager, fragment_second.newInstance(), R.id.contentFrame)
    }

    fun tampilMyFriendsAddFragment() {
        gantiFragment(supportFragmentManager, fragment_first.newInstance(), R.id.contentFrame)
    }
}