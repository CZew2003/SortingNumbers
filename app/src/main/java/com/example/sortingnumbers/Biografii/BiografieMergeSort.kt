package com.example.sortingnumbers.Biografii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.sortingnumbers.MainActivity
import com.example.sortingnumbers.R

class BiografieMergeSort : AppCompatActivity() {

    private lateinit var btInapoiMergeSort: Button // butonul care ne trimite inapoi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setam ca aplicatia sa afiseze layout-ul de la activity_biografie_merge_sort
        setContentView(R.layout.activity_biografie_merge_sort)

        // identificam butonul cu ajutorul id-ului
        btInapoiMergeSort = findViewById(R.id.btInapoiMergeSort)

        // cand apasam butonul ne trimite inapoi la activitatea principala
        btInapoiMergeSort.setOnClickListener {
            inapoi()
        }
    }

    fun inapoi() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}