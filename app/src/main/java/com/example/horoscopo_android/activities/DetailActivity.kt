package com.example.horoscopo_android.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.horoscopo_android.R
import com.example.horoscopo_android.data.Horoscope

class DetailActivity : AppCompatActivity() {

    lateinit var nameTextView: TextView
    lateinit var datesTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameTextView = findViewById(R.id.nameTextView)
        datesTextView = findViewById(R.id.datesTextView)

        val id = intent.getStringExtra("HOROSCOPE_ID")!!

        val horoscope = Horoscope.getById(id)

        nameTextView.setText(horoscope.name)
        datesTextView.setText(horoscope.dates)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(horoscope.name)
        supportActionBar?.setSubtitle(horoscope.dates)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_favorite -> {
                Log.i("MENU", "He pulsado el menu de favorito")
                true
            }
            R.id.action_share -> {
                Log.i("MENU", "He pulsado el menu de compartir")
                true
            }
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}