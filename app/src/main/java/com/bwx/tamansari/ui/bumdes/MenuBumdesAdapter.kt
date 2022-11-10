package com.bwx.tamansari.ui.bumdes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.R
import com.bwx.tamansari.model.MenuListModel

class MenuBumdesAdapter : RecyclerView.Adapter<MenuBumdesAdapter.Viewholder>() {
    private val menu = mutableListOf<MenuListModel>()

    fun updateData(new: MutableList<MenuListModel>) {
        menu.clear()
        menu.addAll(new)
        notifyDataSetChanged()
    }

    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
        private val icon: ImageView = view.findViewById(R.id.icon)
        private val name: TextView = view.findViewById(R.id.name)
        private val description: TextView = view.findViewById(R.id.description)

        fun bindItem(menu: MenuListModel) {
            icon.setImageResource(menu.icon)
            name.text = menu.nama
            description.text = menu.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Viewholder(
        LayoutInflater.from(parent.context).inflate(R.layout.content_menu_list, parent, false)
    )

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bindItem(menu[position])
    }

    override fun getItemCount() = menu.size
}