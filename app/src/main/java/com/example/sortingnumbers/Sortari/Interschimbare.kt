package com.example.sortingnumbers.Sortari

class Interschimbare: Sortare {

    // numarul de pasi realizati pentru ordonare
    var counts: Long = 0

    // metoda de sortare specifica tipului
    override fun sortare(numere: MutableList<Int>) {
        counts = 0
        for(i in 0 until numere.lastIndex) {
            for(j in i + 1..numere.lastIndex) {
                counts++
                if(numere[i] > numere[j]) {
                    numere[i] = numere[j].also { numere[j] = numere[i] }
                }
            }
        }


    }
}