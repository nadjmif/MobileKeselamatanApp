package com.example.nadjmi_3tic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MateriAdapter(context: Context, private val materiList: List<MateriModel>) :
    ArrayAdapter<MateriModel>(context, R.layout.item_materi, materiList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_materi, parent, false)
        val materi = materiList[position]

        val tvTitle = view.findViewById<TextView>(R.id.tvMateriTitle)
        val tvDesc = view.findViewById<TextView>(R.id.tvMateriDesc)
        val chipCategory = view.findViewById<TextView>(R.id.tvMateriCategory)

        tvTitle.text = materi.title
        tvDesc.text = materi.description
        chipCategory.text = materi.category

        return view
    }
}
