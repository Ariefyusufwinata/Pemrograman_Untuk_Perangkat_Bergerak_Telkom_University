package com.rief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val animal = listOf("Ayam", "Bebek", "Domba", "Kambing", "Sapi")
    private var index = 0

//    private var imageView : ImageView = findViewById(R.id.imageView)
//    private var tvHewan: TextView = findViewById(R.id.tvHewan)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext : Button = findViewById(R.id.btnNext)
        val btnPrev : Button = findViewById(R.id.btnPrev)

        btnNext.setOnClickListener {
            nextFunc()
        }
        btnPrev.setOnClickListener {
            prevFunc()
        }
    }

    private fun nextFunc() {
        val imageView : ImageView = findViewById(R.id.imageView)
        val tvHewan: TextView = findViewById(R.id.tvHewan)

        index =
            if (index == animal.size - 1) {
                0
            } else if (index > 4) {
                0
            }  else {
                index + 1
            }

        val id =
            when (index) {
                1 -> R.drawable.bebek
                2 -> R.drawable.domba
                3 -> R.drawable.kambing
                4 -> R.drawable.sapi
                else -> R.drawable.ayam
            }

        Log.e("index", index.toString())

        imageView.setImageResource(id)
        tvHewan.text = animal[index]
    }

    private fun prevFunc() {
        val imageView: ImageView = findViewById(R.id.imageView)
        val tvHewan: TextView = findViewById(R.id.tvHewan)

        index =
            if (index == animal.size + 1) {
                0
            } else if (index <= 0) {
                4
            } else  {
                index - 1
            }

        val id =
            when (index) {
                1 -> R.drawable.bebek
                2 -> R.drawable.domba
                3 -> R.drawable.kambing
                4 -> R.drawable.sapi
                else -> R.drawable.ayam
            }

        Log.d("index", index.toString())

        imageView.setImageResource(id)
        tvHewan.text = animal[index]
    }
}
