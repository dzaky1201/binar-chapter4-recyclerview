package com.dzakyhdr.recyclerview.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.dzakyhdr.recyclerview.R


class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()

    private lateinit var txtName: TextView
    private lateinit var txtPhone: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtName = view.findViewById(R.id.txt_name_detail)
        txtPhone = view.findViewById(R.id.txt_phone_number_detail)
        val name = args.user.name
        val phone = args.user.phone

        txtName.text = name
        txtPhone.text = phone
    }

}