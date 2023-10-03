package com.example.sortingnumbers.Biografii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.sortingnumbers.MainActivity
import com.example.sortingnumbers.R

class BiografieQuickSort : AppCompatActivity() {

    private lateinit var btInapoiQuickSort:Button // butonul care ne trimite inapoi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setam ca aplicatia sa afiseze layout-ul de la activity_biografie_quick_sort
        setContentView(R.layout.activity_biografie_quick_sort)

        // identificam butonul cu ajutorul id-ului
        btInapoiQuickSort = findViewById(R.id.btInapoiQuickSort)

        // cand apasam butonul ne trimite inapoi la activitatea principala
        btInapoiQuickSort.setOnClickListener {
            inapoi()
        }
    }

    private fun inapoi() {
        var intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}