package com.example.baseadapter

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.SeekBar
import android.widget.TextView

class FormActivity : AppCompatActivity() {
    private lateinit var tvColor: TextView
    private lateinit var alpha: SeekBar
    private lateinit var redColor: SeekBar
    private lateinit var greenColor: SeekBar
    private lateinit var blueColor: SeekBar

    private lateinit var tvAlpha: TextView
    private lateinit var tvRed: TextView
    private lateinit var tvGreen: TextView
    private lateinit var tvBlue: TextView
    private lateinit var btFormSalvar: Button
    private lateinit var btFormCancelar: Button
    private lateinit var etDescricao: EditText



    var start = 0
    var end = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.tvColor = findViewById(R.id.TV2_Color)
        this.alpha = findViewById(R.id.Alpha)
        this.redColor = findViewById(R.id.Red)
        this.greenColor = findViewById(R.id.Green)
        this.blueColor = findViewById(R.id.Blue)

        this.tvAlpha = findViewById(R.id.TVAlpha)
        this.tvRed = findViewById(R.id.TVRed)
        this.tvGreen = findViewById(R.id.TVGreen)
        this.tvBlue = findViewById(R.id.TVBlue)
        
        tvColor.setTextColor(Color.WHITE)
        tvColor.setBackgroundColor(Color.BLACK)

        this.alpha.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvColor.setBackgroundColor(Color.argb(progress, redColor.progress, greenColor.progress, blueColor.progress))
                tvColor.text = java.lang.Integer.toHexString(alpha.progress).toString() + java.lang.Integer.toHexString(redColor.progress).toString() + java.lang.Integer.toHexString(greenColor.progress).toString() + java.lang.Integer.toHexString(blueColor.progress).toString()
                tvAlpha.text = progress.toString()
                color()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    start = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    end = seekBar.progress
                }
            }

        })

        redColor.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvColor.setBackgroundColor(Color.argb(alpha.progress, progress, greenColor.progress, blueColor.progress))
                tvColor.text = java.lang.Integer.toHexString(alpha.progress).toString() + java.lang.Integer.toHexString(redColor.progress).toString() + java.lang.Integer.toHexString(greenColor.progress).toString() + java.lang.Integer.toHexString(blueColor.progress).toString()
                tvRed.text = progress.toString()
                color()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    start = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    end = seekBar.progress
                }
            }

        })

        this.greenColor.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvColor.setBackgroundColor(Color.argb(alpha.progress, redColor.progress, progress, blueColor.progress))
                tvColor.text = java.lang.Integer.toHexString(alpha.progress).toString() + java.lang.Integer.toHexString(redColor.progress).toString() + java.lang.Integer.toHexString(greenColor.progress).toString() + java.lang.Integer.toHexString(blueColor.progress).toString()
                tvGreen.text = progress.toString()
                color()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    start = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    end = seekBar.progress
                }
            }

        })

        this.blueColor.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvColor.setBackgroundColor(Color.argb(alpha.progress, redColor.progress, greenColor.progress, progress))
                tvColor.text = java.lang.Integer.toHexString(alpha.progress).toString() + java.lang.Integer.toHexString(redColor.progress).toString() + java.lang.Integer.toHexString(greenColor.progress).toString() + java.lang.Integer.toHexString(blueColor.progress).toString()
                tvBlue.text = progress.toString()
                color()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    start = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    end = seekBar.progress
                }
            }
        })


        this.etDescricao = findViewById(R.id.etDescricao)
        this.btFormSalvar = findViewById(R.id.btFormSalvar)
        this.btFormCancelar = findViewById(R.id.btFormCancelar)

        this.btFormSalvar.setOnClickListener{ salvar() }
        this.btFormCancelar.setOnClickListener{ finish() }
    }

    private fun salvar(){
        val descricao = this.etDescricao.text.toString()
        val argb = intArrayOf(alpha.progress, redColor.progress, greenColor.progress, blueColor.progress)
        val tarefa = Tarefa(descricao, argb)

        val intent = Intent().apply {
            putExtra("TAREFA", tarefa)
        }
        setResult(RESULT_OK, intent)
        finish()
    }

    fun color(){
        if (redColor.progress + greenColor.progress + blueColor.progress < 120 && alpha.progress > 100){
            tvColor.setTextColor(Color.WHITE)
        }
        else{
            tvColor.setTextColor(Color.BLACK)
        }

    }


}