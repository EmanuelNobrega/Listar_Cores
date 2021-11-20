package com.example.baseadapter

import java.io.Serializable
import java.util.*

class Tarefa (var descricao: String, var RGB: IntArray = intArrayOf(255, 0, 0, 0) ): Serializable{
    override fun toString(): String {
        return "$descricao (${RGB[0]}.${RGB[1]}.${RGB[2]}.${RGB[3]})"
    }
}