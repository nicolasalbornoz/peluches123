package com.example.peluches123

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_add.view.*

class DeleteFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var bolean : Boolean = true

        var peluchito = arguments?.getParcelableArrayList<Peluches>("peluchess")
        peluchito?.toMutableList()

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_add, container, false)

        return root
        }


    }
