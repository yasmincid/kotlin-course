package com.example.taste

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class myAdapter(var mCtx: Context, var resource: Int, var items: MutableList<String>) :
    ArrayAdapter<String>(mCtx, resource, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resource, null)
        var tv1: TextView = view.findViewById(R.id.tv1)
        var iTems = items[position]
        tv1.text = iTems
        return view
    }

}