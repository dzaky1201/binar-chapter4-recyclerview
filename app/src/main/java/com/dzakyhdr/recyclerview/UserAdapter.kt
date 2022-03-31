package com.dzakyhdr.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dzakyhdr.recyclerview.ui.HomeFragmentDirections

class UserAdapter(private val data: List<Username>): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    class UserViewHolder(item: View): RecyclerView.ViewHolder(item){
        val textName: TextView = item.findViewById(R.id.txt_name)
        val textPhone: TextView = item.findViewById(R.id.txt_phone_number)
        val rvItem: ConstraintLayout = item.findViewById(R.id.item_rv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.textName.text = data[position].name
        holder.textPhone.text = data[position].phone
        holder.rvItem.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(data[position])
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = data.size
}