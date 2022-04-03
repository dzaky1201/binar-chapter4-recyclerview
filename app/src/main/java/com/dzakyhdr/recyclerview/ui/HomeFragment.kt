package com.dzakyhdr.recyclerview.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dzakyhdr.recyclerview.R
import com.dzakyhdr.recyclerview.UserAdapter
import com.dzakyhdr.recyclerview.Username


class HomeFragment : Fragment() {

    private lateinit var recyelerview: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyelerview = view.findViewById(R.id.rv_user)

        val list = arrayListOf(
            Username("Dzaky Haidar", "085155361372"),
            Username("Farros", "08515XXXX"),
            Username("Salim", "085315XXXX"),
        )

        val adapter = UserAdapter()
        adapter.submitData(list)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyelerview.layoutManager = layoutManager
        recyelerview.adapter = adapter
    }

}