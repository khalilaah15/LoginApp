package com.example.ukl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.navigation.NavigationBarItemView
import com.example.ukl.Product
import com.example.ukl.R
import org.w3c.dom.Text

class GridProduct (val listProduct:ArrayList<Product>):
    RecyclerView.Adapter<GridProduct.GridViewHolder>() {
    class GridViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvHarga: TextView = itemView.findViewById(R.id.harga)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
    }

    override fun onCreateViewHolder(ViewGrup: ViewGroup, i: Int): GridViewHolder {
        val view: View =
            LayoutInflater.from(ViewGrup.context).inflate(R.layout.item_grid, ViewGrup, false)
        return GridViewHolder(view)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallBack(onItemClickCallback: OnItemClickCallBack) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val (name, harga, photo) = listProduct[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            . apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvHarga.text = harga
        holder.btnFavorite.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Favorite " + listProduct[position].name, Toast.LENGTH_SHORT).show() }
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listProduct[position].name, Toast.LENGTH_SHORT).show() }
    }


    interface OnItemClickCallBack : OnItemClickCallback {
        override fun onItemClicked(data: Product)
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Product)
    }
}