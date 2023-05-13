package com.example.ukl

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class fragment_first : Fragment() {
//    private var communicationViewModel: CommunicationViewModel? = null
//    private lateinit var tvDatePicker: TextInputLayout
//    private lateinit var btnDatePicker: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//        communicationViewModel =
//            ViewModelProviders.of(requireActivity()).
//            get(CommunicationViewModel::class.java)
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_first, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val nameEditText = view.findViewById<TextInputEditText>(R.id.textInputTextName)
//        nameEditText.addTextChangedListener (
//            object : TextWatcher {
//                override fun beforeTextChanged(
//                    charSequence: CharSequence, i:Int, i1: Int, i2: Int) {
//                }
//                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//                    communicationViewModel!!.setName(charSequence.toString())
//                }
//
//                override fun afterTextChanged(editable: Editable) {
//                }
//            }
//        )
//        val EmailEditText = view.findViewById<TextInputEditText>(R.id.textInputTextEmail)
//        EmailEditText.addTextChangedListener (
//            object : TextWatcher {
//                override fun beforeTextChanged(
//                    charSequence: CharSequence?, i:Int, i1: Int, i2: Int) {
//                }
//                override fun onTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {
//                    communicationViewModel!!.setEmail(charSequence.toString())
//                }
//
//                override fun afterTextChanged(editable: Editable) {
//                }
//            }
//        )
//
//        val tvDatePicker = view.findViewById<TextInputEditText>(R.id.textInputLayout3)
//        val btnDatePicker = view.findViewById<Button>(R.id.textInputText)
//
//        val myCalender = Calendar.getInstance()
//        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//            myCalender.set(Calendar.YEAR,year)
//            myCalender.set(Calendar.MONTH,month)
//            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//            updateLable(myCalender)
//        }
//        btnDatePicker.setOnClickListener{
//            DatePickerDialog(requireActivity(), datePicker, myCalender.get(Calendar.YEAR),
//            myCalender.get(Calendar.MONTH),
//            myCalender.get(Calendar.DAY_OF_MONTH)).show()
//        }
//    }
//
//    private fun updateLable(mycalender: Calendar) {
//        val myformat = "dd-MM-yyyy"
//        val sdf = SimpleDateFormat(myformat, Locale.UK)
//        tvDatePicker.editText?.setText(sdf.format(mycalender.time))
//    }
//
//    companion object {
//        fun newInstance(): fragment_first {
//            return fragment_first()
//        }
//    }

    private var communicationViewModel: CommunicationViewModel? = null
    lateinit var btnDate : Button
    private var namaInput : String = ""
    private var emailInput : String = ""
    private var ttlInput : String = ""

    private var db : AppDatabase? = null
    private var myFriendDao : MyFriendDao? = null

    private var edtName : EditText? = null
    private var edtEmail : EditText? = null
    private var edtTTL : Button? = null
    private var btnSave: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        communicationViewModel =
            ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()

        btnDate = view.findViewById(R.id.btnDate)
        btnDate.setOnClickListener {
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                { view, year, monthOfYear, dayOfMonth ->
                    btnDate.text = (dayOfMonth.toString()+"\t-\t"+(monthOfYear + 1)+"\t-\t"+year)},
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }

    private fun initView() {
        edtName = activity?.findViewById(R.id.textInputTextName)
        edtEmail = activity?.findViewById(R.id.textInputTextEmail)
        edtTTL = activity?.findViewById(R.id.btnDate)
        btnSave = activity?.findViewById(R.id.btnSave)

        btnSave?.setOnClickListener{
            validasiInput()
        }
    }



    private fun validasiInput() {
        namaInput = edtName?.text.toString()
        emailInput = edtEmail?.text.toString()
        ttlInput = edtTTL?.text.toString()

        when{
            namaInput.isEmpty()-> edtName?.error = "Nama tidak boleh kosong"
            emailInput.isEmpty()->edtEmail?.error = "Email tidak boleh kosong"

            else-> {
                val MyFriend = MyFriend(
                    nama = namaInput,
                    email = emailInput,
                    TTL = ttlInput
                )
                tambahDataRegister(MyFriend)
                Toast.makeText(requireActivity(),"Data Di Simpan", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun tambahDataRegister(friend: MyFriend): Job {
        return GlobalScope.launch { myFriendDao?.tambahTeman(friend) }
    }

    companion object{
        fun newInstance(): fragment_first{
            return fragment_first()
        }
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        myFriendDao = db?.myFriendDao()
    }

    override fun onDestroy() {
        super.onDestroy()
        edtName = null
        edtEmail = null
        edtTTL = null
        btnSave = null
    }
}
