package com.example.peluches123

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class stockItem : Fragment(){

    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_stock,container,false)

        var peluchito = arguments?.getParcelableArrayList<Peluches>("peluchess")
        peluchito?.toMutableList()
        var peluchitos : MutableList<Peluches> = ArrayList()
        peluchitos = peluchito!!

        recyclerView = root.findViewById(R.id.recycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this.context,RecyclerView.VERTICAL,false)

        val pelucheAdapter = PeluchesAdapter(peluchito,this.requireContext())
        recyclerView.adapter = pelucheAdapter

        return root

        }


}