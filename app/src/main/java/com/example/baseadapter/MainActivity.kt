package com.example.baseadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var lvTarefas: ListView
    private lateinit var fabAdd: FloatingActionButton

    private lateinit var lista: ArrayList<Tarefa>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = arrayListOf()

        this.lvTarefas = findViewById(R.id.lvMainPessoas)
        this.fabAdd = findViewById(R.id.fabMainAdd)

        this.lvTarefas.adapter = TarefaAdapter(this, this.lista)

        this.lvTarefas.onItemClickListener = OnClick()
        this.lvTarefas.onItemLongClickListener = OnLongClick()

        val tarefaResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                // cadastrar a pessoa na lista
                val tarefa = it.data?.getSerializableExtra("TAREFA") as Tarefa
                this.lista.add(tarefa)
                (this.lvTarefas.adapter as BaseAdapter).notifyDataSetChanged()
            }
        }

        this.fabAdd.setOnClickListener{
            val intent = Intent(this, FormActivity::class.java)
            tarefaResult.launch(intent)
        }
    }

    inner class OnClick: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val tarefa = this@MainActivity.lista.get(position)
            Toast.makeText(this@MainActivity, tarefa.descricao, Toast.LENGTH_SHORT).show()
        }
    }

    inner class OnLongClick: AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long,
        ): Boolean {
            // excluir a pessoa da lista
            this@MainActivity.lista.removeAt(position)
            (this@MainActivity.lvTarefas.adapter as BaseAdapter).notifyDataSetChanged()
            return true
        }
    }
}