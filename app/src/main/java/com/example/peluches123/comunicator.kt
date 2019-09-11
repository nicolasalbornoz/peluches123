package com.example.peluches123

interface comunicator {
    fun addItem(id:String, nombre: String, precio:String, cantidad:String)
    fun deleteItem (id: String)
}