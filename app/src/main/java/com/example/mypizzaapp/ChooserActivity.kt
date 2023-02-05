package com.example.mypizzaapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers.Main

class ChooserActivity : AppCompatActivity() {

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chooseractivity)

        val data = Intent()
        val resultArray = ArrayList<String>()

        resultArray.add(0,"")
        resultArray.add(1,"")
        resultArray.add(2,"")
        resultArray.add(3,"")

        val cBoxes = arrayOf(
            findViewById<CheckBox>(R.id.checkBox1),
            findViewById<CheckBox>(R.id.checkBox2),
            findViewById<CheckBox>(R.id.checkBox3),
            findViewById<CheckBox>(R.id.checkBox4),
        )

        fun cBoxes() {

            if (cBoxes[0].isChecked) {
                resultArray.add(element = "Peperoni")
            }
            if (cBoxes[1].isChecked) {
                resultArray.add(element = "Salami")
            }
            if (cBoxes[2].isChecked) {
                resultArray.add(element = "Vitlök")
            }
            if (cBoxes[3].isChecked) {
                resultArray.add(element = "Tabasco")
            }
            if (cBoxes[0].isChecked || cBoxes[1].isChecked || cBoxes[2].isChecked || cBoxes[3].isChecked) {
                data.putStringArrayListExtra("Result", resultArray)
                setResult(Activity.RESULT_OK, data)
                finish()
            }
        }

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {

             cBoxes()



        }
    }
}

