package com.bwx.tamansari.ui.wisata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bwx.tamansari.R
import com.bwx.tamansari.model.MenuModel

internal class MenuWisataAdapter(
    private val context: Context,
    val menu: List<MenuModel>
) :
    BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    override fun getCount(): Int {
        return menu.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.content_menu, null)
        }

        imageView = convertView!!.findViewById(R.id.imgMenu)
        textView = convertView.findViewById(R.id.tvNamaMenu)

        imageView.setImageResource(menu[position].image)
        textView.text = menu[position].nama

        return convertView
    }
}