package com.example.peluches123

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.fragment_delete.view.*

class DeleteFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView
    var interfaz : comunicator ?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_delete,container,false)

        root.bBorrar.setOnClickListener {
            var idb = root.eBorar.text.toString()
            interfaz?.deleteItem(idb)
        }
        return root

    }
}
