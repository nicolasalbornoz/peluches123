package com.example.peluches123

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class bottom_navigation : AppCompatActivity(), comunicator {

    override fun addItem(id: String, nombre: String, precio: String, cantidad: String) {
        var peluche = Peluches(id,nombre,precio,cantidad)
        peluchito.add(peluche)
    }

    var peluchito : MutableList<Peluches> = ArrayList()

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        when (item.itemId) {
            R.id.navigation_add -> {
                val addFragment = addItem()
                val bundle = Bundle()
                bundle.putParcelableArrayList("peluchess",ArrayList<Peluches>(peluchito))
                addFragment.arguments=bundle
                transaction.replace(R.id.contenedor,addFragment).commit()

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                val deleteFragment = DeleteFragment()
                textMessage.setText(R.string.title_dashboard)
                transaction.replace(R.id.contenedor,deleteFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_delete -> {
                textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_stock -> {
                val stockFragment = stockItem()
                val bundle = Bundle()
                bundle.putParcelableArrayList("peluchess", ArrayList<Peluches>(peluchito))
                stockFragment.arguments = bundle
                transaction.replace(R.id.contenedor,stockFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val addFragment = addItem()

        transaction.add(R.id.contenedor,addFragment).commit()

        peluchito.add(Peluches("001","peluche 1","$1000","100"))
        peluchito.add(Peluches("002","peluche 2","$2000","1"))


    }
}
