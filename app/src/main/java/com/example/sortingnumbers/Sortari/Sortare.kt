package com.example.sortingnumbers.Sortari

import android.annotation.SuppressLint
import android.widget.TextView

// Ne va obliga clasele care extind interfata Sortare sa aiba cele doua functii specifice unui tip
// de sortare: functia sortare() si functia updateInfo()
interface Sortare {
    fun sortare(numere: MutableList<Int>)

    fun updateInfo(counts: Long,
                   afisarePasi: TextView) {

        afisarePasi.text = "Numar de pasi: $counts"
    }
}