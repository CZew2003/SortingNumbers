package com.example.sortingnumbers.Sortari

class MergeSort: Sortare {

    // numarul de pasi realizati pentru ordonare
    var counts: Long = 0

    // metoda de sortare specifica tipului
    override fun sortare(numere: MutableList<Int>) {
        counts = 0
        mergeSort(numere, 0, numere.lastIndex)
    }

    private fun mergeSort(numere: MutableList<Int>, st: Int, dr: Int) {

        var tmp = Array<Int>(numere.size + 1) {i -> 0}

        //tmp.forEach { Log.i("Numere", it.toString()) }

        var mij: Int
        if(st < dr) {
            mij = (st + dr) / 2
            mergeSort(numere, st, mij)
            mergeSort(numere, mij + 1, dr)

            var i = st
            var j = mij + 1
            var k = 0

            while (i <= mij && j <= dr) {
                counts++
                if(numere[i] < numere[j]) {
                    tmp[++k] = numere[i++]
                } else {
                    tmp[++k] = numere[j++]
                }
            }

            while (i <= mij) {
                counts++
                tmp[++k] = numere[i++]
            }
            while (j <= dr) {
                counts++
                tmp[++k] = numere[j++]
            }

            i = st
            j = 1
            while (i <= dr) {
                counts++
                numere[i] = tmp[j]
                i++
                j++
            }
        }
    }
}