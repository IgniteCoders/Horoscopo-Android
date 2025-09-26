package com.example.horoscopo_android.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo_android.R
import com.example.horoscopo_android.adapters.HoroscopeAdapter
import com.example.horoscopo_android.data.Horoscope

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    val horoscopeList: List<Horoscope> = Horoscope.Companion.getAll()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)

        val adapter = HoroscopeAdapter(horoscopeList, ::onItemClickListener)

        /*val adapter = HoroscopeAdapter(horoscopeList) {
            val horoscope = horoscopeList[it]
            goToDetail(horoscope)
        }*/

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)

        val searchView = menu!!.findItem(R.id.action_search).actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // TODO: Filtrar la lista de horoscopos y mostrarlos
                return true
            }
        })

        return true
    }

    fun onItemClickListener(position: Int) {
        val horoscope = horoscopeList[position]
        goToDetail(horoscope)
    }

    fun goToDetail(horoscope: Horoscope) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("HOROSCOPE_ID", horoscope.id)
        startActivity(intent)
    }
}