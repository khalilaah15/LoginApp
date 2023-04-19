package com.example.ukl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class fragment_second : Fragment() {
//    private var communicationViewModel: CommunicationViewModel? = null
//    private var txtName: TextView? = null
//    private var txtEmail : TextView? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        communicationViewModel = ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_second, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        txtName = view.findViewById(R.id.textViewName)
//        communicationViewModel!!.name.observe(requireActivity(),
//            Observer{s -> txtName!!.text = s})
//
//        txtEmail = view.findViewById(R.id.textViewEmail)
//        communicationViewModel!!.email.observe(requireActivity(),
//            Observer{s -> txtEmail!!.text = s})
//    }
//
//
//    companion object {
//        fun newInstance(): fragment_second{
//            return fragment_second()
//        }
//    }

    private var listTeman : kotlin.collections.List<MyFriend>? = null
    private var listMyFriend : RecyclerView? = null
    private var db : AppDatabase? = null
    private var myFriendDao : MyFriendDao? = null
    private var communicationViewModel: CommunicationViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communicationViewModel = ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDb()
        initView()
    }

    private fun initLocalDb() {
        db = AppDatabase.getAppDataBase(requireActivity())
        myFriendDao = db?.myFriendDao()
    }

    private fun initView() {
        listMyFriend = activity?.findViewById(R.id.listMyFriends)
        ambilData()
    }

    private fun ambilData() {
        listTeman = ArrayList()
        myFriendDao?.ambilSemuaTeman()?.observe(requireActivity()){
            r -> listTeman = r
            when{
                listTeman?.size == 0 -> tampilToast("Belum ada Data")
                else -> {
                    tampilData()
                }
            }
        }
    }

    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(),message,Toast.LENGTH_SHORT).show()
    }

    private fun tampilData(){
        listMyFriend?.layoutManager = LinearLayoutManager(activity)
        listMyFriend?.adapter = MyFriendAdapter(requireActivity(), listTeman!! as ArrayList<MyFriend>)
    }

    companion object{
        fun newInstance(): fragment_second{
            return fragment_second()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        listMyFriend = null
    }
}