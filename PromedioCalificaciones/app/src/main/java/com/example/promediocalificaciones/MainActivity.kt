package com.example.promediocalificaciones

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun average(view: View) {
        val math = findViewById<EditText>(R.id.mathGrades)
        val phy = findViewById<EditText>(R.id.physicalGrades)
        val english = findViewById<EditText>(R.id.englishGrades)
        var status = findViewById<TextView>(R.id.statusTV)
        val mathGrade = math.text.toString().toInt()
        val phyGrade = phy.text.toString().toInt()
        val enGrade = english.text.toString().toInt()
        val average = (mathGrade + phyGrade + enGrade) / 3
        if (average >= 3) {
            status.setText("Status: Approved " + " Grade : " + average.toString())
            status.setTextColor(Color.GREEN)
        } else {
            status.setText("Status: Failed " + " Grade :  " + average.toString())
            status.setTextColor(Color.RED)
        }
    }
}
