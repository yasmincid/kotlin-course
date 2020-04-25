package com.example.mybd

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var tvCode: EditText? = null
    private var tvName: TextView? = null
    private var tvPrice: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvCode = findViewById<EditText>(R.id.txt_code)
        tvName = findViewById<EditText>(R.id.txt_name)
        tvPrice = findViewById<EditText>(R.id.txt_price)
    }

    fun addArticle(view: View) {
        val admin = MyBDSqliteOpenHelper(this, "Articles", null, 1)
        val bd: SQLiteDatabase = admin.writableDatabase
        val tvCodeS = tvCode?.text.toString()
        val tvNameS = tvName?.text.toString()
        val tvPriceS = tvPrice?.text.toString()
        if (tvCodeS.isNotEmpty() && tvNameS.isNotEmpty() && tvPriceS.isNotEmpty()) {
            var values = ContentValues()
            values.put("code", tvCodeS)
            values.put("name", tvNameS)
            values.put("price", tvPriceS)
            bd.insert("article", null, values)
            tvCode?.setText("")
            tvName?.setText("")
            tvPrice?.setText("")
            bd.close()

            Toast.makeText(this, "ADD", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "You have to introduce all fields", Toast.LENGTH_SHORT).show()
        }
    }

    fun findArticle(view: View) {
        val admin = MyBDSqliteOpenHelper(this, "Articles", null, 1)
        val bd: SQLiteDatabase = admin.writableDatabase
        val tvCodeS = tvCode?.text.toString()
        if (tvCodeS.isNotEmpty()) {
            var cursor: Cursor = bd.rawQuery("select name, price from article where code = " + tvCodeS, null)
            if (cursor.moveToFirst()) {
                tvName?.setText(cursor.getString(0))
                tvPrice?.setText(cursor.getString(1))
                bd.close()
            } else {
                Toast.makeText(this, "There is not an article with that code", Toast.LENGTH_SHORT).show()
                bd.close()
            }

        } else {
            Toast.makeText(this, "you should introduce a code", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteArticle(view: View) {
        val admin = MyBDSqliteOpenHelper(this, "Articles", null, 1)
        val bd: SQLiteDatabase = admin.writableDatabase
        val tvCodeS = tvCode?.text.toString()
        if (tvCodeS.isNotEmpty()) {
            var cant = bd.delete("article", "code=" + tvCodeS, null)
            bd.close()
            tvCode?.setText("")
            tvName?.setText("")
            tvPrice?.setText("")
            if (cant == 1) {
                Toast.makeText(this, "The article was delete", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "The article doesn't exits", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "you should introduce a code", Toast.LENGTH_SHORT).show()
            bd.close()
        }
    }

    fun editArticle(view: View) {
        val admin = MyBDSqliteOpenHelper(this, "Articles", null, 1)
        val bd: SQLiteDatabase = admin.writableDatabase
        val tvCodeS = tvCode?.text.toString()
        val tvNameS = tvName?.text.toString()
        val tvPriceS = tvPrice?.text.toString()
        if (tvCodeS.isNotEmpty() && tvNameS.isNotEmpty() && tvPriceS.isNotEmpty()) {
            var values = ContentValues()
            values.put("code", tvCodeS)
            values.put("name", tvNameS)
            values.put("price", tvPriceS)

            val cant = bd.update("article", values, "code =" + tvCodeS, null)
            bd.close()
            if (cant == 1) {
                Toast.makeText(this, "The article was update", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "The article doesn't exits", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "you should introduce a code", Toast.LENGTH_SHORT).show()
            bd.close()
        }

    }
}

