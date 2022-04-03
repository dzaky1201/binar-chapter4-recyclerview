package com.dzakyhdr.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dzakyhdr.recyclerview.ui.HomeFragmentDirections

class UserAdapter() : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<Username>() {
        // untuk membedakan item
        override fun areItemsTheSame(oldItem: Username, newItem: Username): Boolean {
            return oldItem.phone == newItem.phone
        }

        //untuk menentukan indikator apakah item pada dataset berubah
        override fun areContentsTheSame(oldItem: Username, newItem: Username): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitData(value: ArrayList<Username>) = differ.submitList(value)

    class UserViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val textName: TextView = item.findViewById(R.id.txt_name)
        val textPhone: TextView = item.findViewById(R.id.txt_phone_number)
        val rvItem: ConstraintLayout = item.findViewById(R.id.item_rv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.textName.text = data.name
        holder.textPhone.text = data.phone
        holder.rvItem.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(data)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size
}