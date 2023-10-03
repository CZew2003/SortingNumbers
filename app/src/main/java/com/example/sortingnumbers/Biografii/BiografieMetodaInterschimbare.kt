package com.example.sortingnumbers.Biografii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.sortingnumbers.MainActivity
import com.example.sortingnumbers.R

class BiografieMetodaInterschimbare : AppCompatActivity() {

    private lateinit var btInapoiMetodaInterschimbare: Button // butonul care ne trimite inapoi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setam ca aplicatia sa afiseze layout-ul de la activity_biografie_metoda_interschimbare
        setContentView(R.layout.activity_biografie_metoda_interschimbare)

        // identificam butonul cu ajutorul id-ului
        btInapoiMetodaInterschimbare = findViewById(R.id.btInapoiMetodaInterschimbare)

        // cand apasam butonul ne trimite inapoi la activitatea principala
        btInapoiMetodaInterschimbare.setOnClickListener {
            inapoi()
        }
    }

    private fun inapoi() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}