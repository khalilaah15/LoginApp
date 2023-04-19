package com.example.ukl

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.RemoteViews.RemoteCollectionItems
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.text.FieldPosition

//class ViewPagerAdapter (private val mContext: Context, fm: FragmentManager) :
//    FragmentPagerAdapter(fm) {
//    override fun getItem(position: Int): Fragment {
//        return if (position == 0) {
//            fragment_first.newInstance()
//        } else {
//            fragment_second.newInstance()
//        }
//    }
//    override fun getPageTitle(position: Int): CharSequence? {
//        return mContext.resources.getString(TAB_TITLES[position])
//    }
//
//    override fun getCount(): Int {
//        return 2
//    }
//    companion object {
//        @StringRes
//        private val TAB_TITLES = intArrayOf(R.string.tab_text_1, R.string.tab_text_2)
//    }
//}

class MyFriendAdapter(private val context: Context, private val items: ArrayList<MyFriend>) :
    RecyclerView.Adapter<MyFriendAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_item, parent, false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        private var txtFriendName: TextView = itemView.findViewById(R.id.txtFriendName)
        private var txtFriendEmail: TextView = itemView.findViewById(R.id.txtFriendEmail)
        private var txtFriendTTL: TextView = itemView.findViewById(R.id.txtFriendTTL)

        fun bindItem(item: MyFriend) {
            txtFriendName.text = item.nama
            txtFriendEmail.text = item.email
            txtFriendTTL.text = item.TTL
        }
    }

        }