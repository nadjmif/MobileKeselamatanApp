package com.example.nadjmi_3tic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class KontakAdapter(context: Context, private val kontakList: List<KontakModel>) :
    ArrayAdapter<KontakModel>(context, R.layout.item_kontak, kontakList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_kontak, parent, false)
        val kontak = kontakList[position]

        val tvName = view.findViewById<TextView>(R.id.tvKontakName)
        val tvType = view.findViewById<TextView>(R.id.tvKontakType)
        val tvDistance = view.findViewById<TextView>(R.id.tvKontakDistance)
        val btnLihat = view.findViewById<Button>(R.id.btnLihatKontak)

        tvName.text = kontak.name
        tvType.text = kontak.type
        tvDistance.text = kontak.distance

        btnLihat.setOnClickListener {
            Toast.makeText(context, "Melihat lokasi ${kontak.name}", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
