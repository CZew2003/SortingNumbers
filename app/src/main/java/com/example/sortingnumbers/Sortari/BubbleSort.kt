package com.example.sortingnumbers.Sortari

class BubbleSort: Sortare {

    // numarul de pasi realizati pentru ordonare
    var counts: Long = 10

    // metoda de sortare specifica tipului
    override fun sortare(numere: MutableList<Int>) {
        counts = 0
        var ok: Boolean
        do {
            ok = true
            for(i in 0 until numere.lastIndex) {
                counts++
                if(numere[i] > numere[i + 1]) {
                    numere[i] = numere[i + 1].also { numere[i + 1] = numere[i] }
                    ok = false
                }
            }
        }while (!ok)
    }

}