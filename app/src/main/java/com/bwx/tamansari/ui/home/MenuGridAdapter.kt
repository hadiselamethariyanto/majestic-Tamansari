package com.bwx.tamansari.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.R
import com.bwx.tamansari.model.MenuModel

class MenuGridAdapter(val list: List<MenuModel>, val context: Context) :
    RecyclerView.Adapter<MenuGridAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.content_menu, parent, false)
        return ViewHolder(v); }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(list[position], position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNamaMenu: TextView = view.findViewById(R.id.tvNamaMenu)
        private val imgMenu: ImageView = view.findViewById(R.id.imgMenu)

        fun bindItem(menu: MenuModel) {
            tvNamaMenu.text = menu.nama
            imgMenu.setImageResource(menu.image)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MenuModel, position: Int)
    }
}