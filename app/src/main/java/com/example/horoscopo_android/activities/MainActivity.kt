package com.example.horoscopo_android.activities

import android.content.Intent
import android.os.Bundle
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
    lateinit var adapter: HoroscopeAdapter

    var horoscopeList: List<Horoscope> = Horoscope.getAll()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setTitle(R.string.activity_main_title)

        recyclerView = findViewById(R.id.recyclerView)

        adapter = HoroscopeAdapter(emptyList(), ::onItemClickListener)

        /*val adapter = HoroscopeAdapter(horoscopeList) {
            val horoscope = horoscopeList[it]
            goToDetail(horoscope)
        }*/

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()

        adapter.updateItems(horoscopeList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)

        val searchView = menu!!.findItem(R.id.action_search).actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                horoscopeList = Horoscope.getAll().filter {
                    getString(it.name).contains(newText, true)
                    || getString(it.dates).contains(newText, true)
                }

                adapter.updateItems(horoscopeList)
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