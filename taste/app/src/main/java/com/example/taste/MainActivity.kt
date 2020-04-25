package com.example.taste

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var list = arrayOf("5", "8", "5", "8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lista = findViewById<ListView>(R.id.lv1)
        var adapter = myAdapter(this, R.layout.list, list.toMutableList())
        lista.adapter = adapter
        lista.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "The seleted position is: " + position.toString(), Toast.LENGTH_LONG).show()
        })
    }
}
