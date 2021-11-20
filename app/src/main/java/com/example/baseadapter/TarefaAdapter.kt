package com.example.baseadapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class TarefaAdapter (var contexto: Context, var lista: ArrayList<Tarefa>) : BaseAdapter() {

    override fun getCount(): Int {
        return this.lista.count()
    }

    override fun getItem(position: Int): Any {
        return this.lista.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = if (convertView == null){
            LayoutInflater.from(this.contexto).inflate(R.layout.tarefa_layout, parent, false)
        }else{
            convertView
        }

        val tarefa = this.lista.get(position)

        val cor = view.findViewById<TextView>(R.id.tvNome)
        val valor = view.findViewById<TextView>(R.id.tvValor)
        val icon = view.findViewById<ImageView>(R.id.ivIcon)

        cor.text = tarefa.descricao
        valor.text = "ARGB: ${tarefa.RGB[0]}.${tarefa.RGB[1]}.${tarefa.RGB[2]}.${tarefa.RGB[3]}"
        icon.setColorFilter(Color.argb(tarefa.RGB[0], tarefa.RGB[1], tarefa.RGB[2], tarefa.RGB[3]))

        view.minimumHeight = 100

        return view
    }
}