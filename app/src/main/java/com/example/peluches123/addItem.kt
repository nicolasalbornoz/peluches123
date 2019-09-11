package com.example.peluches123

import android.os.Bundle
import androidx.fragment.app.Fragment


import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_add.view.*
import java.lang.ClassCastException

class addItem: Fragment()
{
    var interfaz : comunicator ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_add, container, false)

        root.btnAdd.setOnClickListener{
            var ids = root.eid.text.toString()
            var nom = root.eNombre.text.toString()
            var pre = root.ePrecio.text.toString()
            var cant = root.eStock.text.toString()
            if(ids.isEmpty() || nom.isEmpty() || pre.isEmpty() || cant.isEmpty()){
                Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
            }else{

                val builder = AlertDialog.Builder(this.context)
                builder.setTitle("CONFIRMAR INGRESO")
                builder.setMessage("ID: $ids \nNombre: $nom \nPrecio: $pre \nCantidad $cant \n")
                //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    Toast.makeText(context,"Agregado", Toast.LENGTH_SHORT).show()
                    interfaz?.addItem(ids,nom,pre,cant)
                    root.eid.text.clear()
                    root.eNombre.text.clear()
                    root.ePrecio.text.clear()
                    root.eStock.text.clear()
                }
                builder.setNegativeButton(android.R.string.no) { dialog, which ->
                    Toast.makeText(context,"No Agregado", Toast.LENGTH_SHORT).show()
                }
                builder.show()
                /* }else{
                     Toast.makeText(context, "Ya Existente", Toast.LENGTH_SHORT).show()
                 }*/


                /*interfaz?.agregarDatos(id,nom,pre,cant)
                root.eid.text.clear()
                root.eNombre.text.clear()
                root.ePrecio.text.clear()
                root.eCantidad.text.clear()*/

            }

        }
        return root

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            interfaz = context as comunicator
        }catch (e: ClassCastException){
            Log.d("exception", e.toString())
        }
    }

}