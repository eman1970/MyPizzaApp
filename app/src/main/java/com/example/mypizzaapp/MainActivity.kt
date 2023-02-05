package com.example.mypizzaapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.mypizzaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val txt = findViewById<TextView>(R.id.textView)
        val intentLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val resultArray: ArrayList<String> = result.data?.getStringArrayListExtra("Result")!!
                txt.text = "Tillbehör: " + resultArray.toString().replace("[", "").replace("]", "").replace(",","")
            }
        }

        binding.button.setOnClickListener {
            intent = Intent(this, ChooserActivity::class.java)
            intentLauncher.launch(intent)
        }
    }
    }
