package com.bwx.tamansari.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bwx.tamansari.R
import com.bwx.tamansari.model.MenuModel
import com.bwx.tamansari.ui.berita.BeritaActivity
import com.bwx.tamansari.ui.bumdes.BumdesActivity
import com.bwx.tamansari.ui.pemdes.PemdesActivity
import com.bwx.tamansari.ui.peta.PetaActivity
import com.bwx.tamansari.ui.spbu.SpbuActivity
import com.bwx.tamansari.ui.tpsr.TpsrActivity
import com.bwx.tamansari.ui.wisata.DashboardWisata

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
//            if (position == 0) {
//                context.startActivity(Intent(context, DashboardWisata::class.java))
//            }
//            else if (position == 1) {
//                context.startActivity(Intent(context, SpbuActivity::class.java))
//            } else if (position == 2) {
//                context.startActivity(Intent(context, BumdesActivity::class.java))
//            } else if (position == 3) {
//                context.startActivity(Intent(context, PetaActivity::class.java))
//            } else if (position == 4) {
//                context.startActivity(Intent(context, DashboardWisata::class.java))
//            } else if (position == 5) {
//                context.startActivity(Intent(context, BeritaActivity::class.java))
//            } else if (position == 6) {
//                context.startActivity(Intent(context, TpsrActivity::class.java))
//            }
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