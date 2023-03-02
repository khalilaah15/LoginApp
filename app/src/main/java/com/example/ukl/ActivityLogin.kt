package com.example.ukl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityLogin : AppCompatActivity() {

    private lateinit var rvProduct: RecyclerView
    private var list: ArrayList<Product> = arrayListOf()
    private var title: String = "Lightstick Area"

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)
            setActionBarTitle(title)

            rvProduct = findViewById(R.id.rv_product)
            rvProduct.setHasFixedSize(true)

            list.addAll(ProductData.listProduct)
            showRecyclerGrid()
        }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            menuInflater.inflate(R.menu.menu, menu)
            return super.onCreateOptionsMenu(menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            setMode(item.itemId)
            return super.onOptionsItemSelected(item)
        }

        private fun setMode(selectedMode: Int) {
            when (selectedMode) {
                R.id.action_grid -> {
                    showRecyclerGrid()
                }
                R.id.action_cardview -> {
                    showRecyclerCardView()
                }
            }
        }

        private fun showRecyclerGrid() {
            rvProduct.layoutManager = GridLayoutManager(this, 2)
            val gridProduct = GridProduct(list)
            rvProduct.adapter = gridProduct
        }

        private fun showRecyclerCardView() {
           rvProduct.layoutManager = LinearLayoutManager(this)
            val cardViewProduct = CardView(list)
            rvProduct.adapter = cardViewProduct
        }

        private fun setActionBarTitle(title: String) {
            if (supportActionBar != null) {
                (supportActionBar as ActionBar).title = title
            }
        }

        private fun showSelectedProduct(product: Product) {
            Toast.makeText(this, "Kamu memilih " + product.name, Toast.LENGTH_SHORT).show()
        }
    }