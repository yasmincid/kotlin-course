package com.example.mycalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var lastNumber: String? = null
    private var operator: String? = null
    private var one: Button? = null
    private var two: Button? = null
    private var three: Button? = null
    private var four: Button? = null
    private var five: Button? = null
    private var six: Button? = null
    private var seven: Button? = null
    private var eight: Button? = null
    private var nine: Button? = null
    private var zero: Button? = null
    private var mult: Button? = null
    private var divide: Button? = null
    private var sum: Button? = null
    private var sub: Button? = null
    private var equal: Button? = null
    private var point: Button? = null
    private var ca: Button? = null
    private var del: Button? = null
    private var percent: Button? = null
    private var tvNumber: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        zero = findViewById<Button>(R.id.btnZero)
        one = findViewById<Button>(R.id.btnOne)
        two = findViewById<Button>(R.id.btnTwo)
        three = findViewById<Button>(R.id.btnThree)
        four = findViewById<Button>(R.id.btnFour)
        five = findViewById<Button>(R.id.btnFive)
        six = findViewById<Button>(R.id.btnSix)
        seven = findViewById<Button>(R.id.btnSeven)
        eight = findViewById<Button>(R.id.btnEight)
        nine = findViewById<Button>(R.id.btnNine)
        sum = findViewById<Button>(R.id.btnSum)
        sub = findViewById<Button>(R.id.btnSub)
        mult = findViewById<Button>(R.id.btnMul)
        divide = findViewById<Button>(R.id.btnDivide)
        equal = findViewById<Button>(R.id.btnEqual)
        point = findViewById<Button>(R.id.btnPoint)
        percent = findViewById<Button>(R.id.btnPercent)
        ca = findViewById<Button>(R.id.btnCA)
        del = findViewById<Button>(R.id.btnDel)
        tvNumber = findViewById<TextView>(R.id.tvNumber)

        one!!.setOnClickListener(this)
        two!!.setOnClickListener(this)
        three!!.setOnClickListener(this)
        four!!.setOnClickListener(this)
        five!!.setOnClickListener(this)
        six!!.setOnClickListener(this)
        seven!!.setOnClickListener(this)
        eight!!.setOnClickListener(this)
        nine!!.setOnClickListener(this)
        zero!!.setOnClickListener(this)
        mult!!.setOnClickListener(this)
        sub!!.setOnClickListener(this)
        sum!!.setOnClickListener(this)
        divide!!.setOnClickListener(this)
        point!!.setOnClickListener(this)
        ca!!.setOnClickListener(this)
        del!!.setOnClickListener(this)
        equal!!.setOnClickListener(this)
        percent!!.setOnClickListener(this)
        tvNumber!!.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        var result: Float = 0f
        when (v?.id) {
            R.id.btnZero -> {
                tvNumber?.setText(tvNumber?.text.toString() + "0")
            }
            R.id.btnOne -> {
                tvNumber?.setText(tvNumber?.text.toString() + "1")
            }
            R.id.btnTwo -> {
                tvNumber?.setText(tvNumber?.text.toString() + "2")
            }
            R.id.btnThree -> {
                tvNumber?.setText(tvNumber?.text.toString() + "3")
            }
            R.id.btnFour -> {
                tvNumber?.setText(tvNumber?.text.toString() + "4")
            }
            R.id.btnFive -> {
                tvNumber?.setText(tvNumber?.text.toString() + "5")
            }
            R.id.btnSix -> {
                tvNumber?.setText(tvNumber?.text.toString() + "6")
            }
            R.id.btnSeven -> {
                tvNumber?.setText(tvNumber?.text.toString() + "6")
            }
            R.id.btnEight -> {
                tvNumber?.setText(tvNumber?.text.toString() + "8")
            }
            R.id.btnNine -> {
                tvNumber?.setText(tvNumber?.text.toString() + "9")
            }
            R.id.btnPoint -> {
                tvNumber?.setText(tvNumber?.text.toString() + ".")
            }
            R.id.btnCA -> {
                tvNumber?.setText("")
                tvNumber?.setHint("0")
            }
            R.id.btnDel -> {
                var cadena = tvNumber?.text.toString()
                if (!(cadena.equals("")) && (cadena != null))
                    cadena = cadena.substring(0, cadena.length - 1)
                tvNumber?.setText(cadena)
            }
            R.id.btnSum -> {
                lastNumber = tvNumber?.text.toString()
                tvNumber?.setText("")
                operator = "+"
            }
            R.id.btnDivide -> {
                lastNumber = tvNumber?.text.toString()
                tvNumber?.setText("")
                operator = "/"
            }
            R.id.btnSub -> {
                lastNumber = tvNumber?.text.toString()
                tvNumber?.setText("")
                operator = "-"
            }
            R.id.btnMul -> {
                lastNumber = tvNumber?.text.toString()
                tvNumber?.setText("")
                operator = "*"
            }
            R.id.btnPercent -> {
                lastNumber = tvNumber?.text.toString()
                tvNumber?.setText("")
                operator = "%"
            }
            R.id.btnEqual -> {
                when (operator) {
                    "+" -> {
                        result = lastNumber?.toFloat()!! + tvNumber?.text.toString().toFloat()
                        tvNumber?.setText(result.toString())

                    }
                    "-" -> {
                        result = lastNumber?.toFloat()!! - tvNumber?.text.toString().toFloat()
                        tvNumber?.setText(result.toString())
                    }
                    "*" -> {
                        result = lastNumber?.toFloat()!! * tvNumber?.text.toString().toFloat()
                        tvNumber?.setText(result.toString())
                    }
                    "/" -> {
                        result = lastNumber?.toFloat()!! / tvNumber?.text.toString().toFloat()
                        tvNumber?.setText(result.toString())

                    }
                    "%" -> {
                        result = lastNumber?.toFloat()!! * tvNumber?.text.toString().toFloat() / 100
                        tvNumber?.setText(result.toString())
                    }
                }
            }

        }
    }
}
