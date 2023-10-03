package com.example.sortingnumbers.Sortari

class QuickSort: Sortare {

    // numarul de pasi realizati pentru ordonare
    var counts: Long = 0

    override fun sortare(numere: MutableList<Int>) {
        counts = 0
        quickSort(numere, 0, numere.lastIndex)
    }

    // metoda de sortare specifica tipului
    private fun quickSort(numere: MutableList<Int>, st: Int, dr: Int) {

        if(st < dr) {
            var mij = (st + dr) / 2
            numere[st] = numere[mij].also { numere[mij] = numere[st] }
            var i = st
            var j = dr
            var d = 0
            while (i < j) {
                counts++
                if(numere[i] > numere[j]) {
                    numere[i] = numere[j].also { numere[j] = numere[i] }
                    d = 1 - d
                }
                i += d
                j -= 1 - d
            }
            quickSort(numere, st, i - 1)
            quickSort(numere, i + 1, dr)
        }
    }
}