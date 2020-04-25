package com.example.fruitlist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selection(view: View) {
        when (view.id) {
            R.id.btnBananas -> {
                Toast.makeText(this, "Banana", Toast.LENGTH_SHORT).show()
            }
            R.id.btnFresa -> {
                Toast.makeText(this, "Strawberry", Toast.LENGTH_SHORT).show()
            }
            R.id.btnKiwi -> {
                Toast.makeText(this, "Kiwi", Toast.LENGTH_SHORT).show()
            }
            R.id.btnMango -> {
                Toast.makeText(this, "Mango", Toast.LENGTH_SHORT).show()
            }
            R.id.btnManzana -> {
                Toast.makeText(this, "Apple", Toast.LENGTH_SHORT).show()
            }
            R.id.btnMelon -> {
                Toast.makeText(this, "Melon", Toast.LENGTH_SHORT).show()
            }
            R.id.btnPina -> {
                Toast.makeText(this, "Pineaple", Toast.LENGTH_SHORT).show()
            }
            R.id.btnGros -> {
                Toast.makeText(this, "Redcurrant", Toast.LENGTH_SHORT).show()
            }
            R.id.btnPera -> {
                Toast.makeText(this, "Peach", Toast.LENGTH_SHORT).show()
            }
            R.id.btnZamora -> {
                Toast.makeText(this, "Zamora", Toast.LENGTH_SHORT).show()
            }
            R.id.btnMoras -> {
                Toast.makeText(this, "Blackberry", Toast.LENGTH_SHORT).show()
            }
            R.id.btnSandia -> {
                Toast.makeText(this, "Watermelon", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
