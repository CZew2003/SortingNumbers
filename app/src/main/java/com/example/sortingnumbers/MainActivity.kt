package com.example.sortingnumbers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.sortingnumbers.Biografii.BiografieMergeSort
import com.example.sortingnumbers.Biografii.BiografieMetodaBulelor
import com.example.sortingnumbers.Biografii.BiografieMetodaInterschimbare
import com.example.sortingnumbers.Biografii.BiografieQuickSort
import com.example.sortingnumbers.Sortari.BubbleSort
import com.example.sortingnumbers.Sortari.Interschimbare
import com.example.sortingnumbers.Sortari.MergeSort
import com.example.sortingnumbers.Sortari.QuickSort
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var btInterschimbare: Button // butonul pentru metoda interschimbarii
    private lateinit var btMetodaBulelor: Button // butonul pentru metoda bulelor
    private lateinit var btQuickSort: Button // butonul pentru metoda quicksort
    private lateinit var btMergeSort: Button // butonul pentru metoda mergesort
    private lateinit var btSortare: Button // butonul pentru sortare
    private lateinit var btStergere: Button // butonul pentru stergere
    private lateinit var etNumere: EditText // EditTextul unde se introduc numerele
    private lateinit var tvInterschimbare: TextView // Textul cu pasii de metoda interschimbarii
    private lateinit var tvMetodaBulelor: TextView // Textul cu pasii de metoda bulelor
    private lateinit var tvQuickSort: TextView // Textul cu pasii de metoda quicksort
    private lateinit var tvMergeSort: TextView // Textul cu pasii de metoda mergesort
    private lateinit var tvNumere: TextView // Textul cu numerele ordonate crescator
    private lateinit var tvCateNumere: TextView // Textul cu cate numere de ordonat

    private var numere = mutableListOf<Int>() // O lista cu numerele introduse
    private var numere1 = mutableListOf<Int>() // O copie a variabilei numere care ne va ajuta
                                                // la sortare

    private lateinit var bubbleSort: BubbleSort // obiectul clasei BubbleSort
    private lateinit var interschimbare: Interschimbare // obiectul clasei BubbleSort
    private lateinit var quickSort: QuickSort // obiectul clasei BubbleSort
    private lateinit var mergeSort: MergeSort // obiectul clasei BubbleSort

    private var ok: Boolean = true // variabila prin care verificam corectitudinea textului

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setam ca aplicatia sa afiseze layout-ul de la activity_main
        setContentView(R.layout.activity_main)

        // deoarece fiecare widget are propriul id il vom cauta cu ajutorul functiei
        // findViewById(id) unde vom cauta id-ul respectiv
        btInterschimbare = findViewById(R.id.btInterschimbare)
        btMetodaBulelor = findViewById(R.id.btMetodaBulelor)
        btQuickSort = findViewById(R.id.btQuickSort)
        btMergeSort = findViewById(R.id.btMergeSort)
        btSortare = findViewById(R.id.btSortare)
        btStergere = findViewById(R.id.btStergere)
        etNumere = findViewById(R.id.etNumere)
        tvInterschimbare = findViewById(R.id.tvInterschimbare)
        tvMetodaBulelor = findViewById(R.id.tvMetodaBulelor)
        tvQuickSort = findViewById(R.id.tvQuickSort)
        tvMergeSort = findViewById(R.id.tvMergeSort)
        tvNumere = findViewById(R.id.tvNumere)
        tvCateNumere = findViewById(R.id.tvCateNumere)

        // creem instantele claselor care se ocupa cu sortarea
        bubbleSort = BubbleSort()
        interschimbare = Interschimbare()
        quickSort = QuickSort()
        mergeSort = MergeSort()


        // le asociem butoanelor functii specifice atunci cand sunt apasate
        btSortare.setOnClickListener {

            ok = true
            //citim numerele
            citesteNumere()

            // daca au fost introduse corect facem sortarile si afisam pe ecran sortarea si
            // numarul de pasi
            if(ok) {
                sortareInterschimbare()
                sortareBule()
                sortareQuickSort()
                sortareMergeSort()
                updateInfo()
            } else {
                // altfel stergem tot ce se afla pe EditText
                etNumere.text = null
            }
        }

        btStergere.setOnClickListener {
            sterge()
        }

        btInterschimbare.setOnClickListener {
            schimbaActivitatea(BiografieMetodaInterschimbare())
        }

        btMetodaBulelor.setOnClickListener {
            schimbaActivitatea(BiografieMetodaBulelor())
        }

        btQuickSort.setOnClickListener {
            schimbaActivitatea(BiografieQuickSort())
        }

        btMergeSort.setOnClickListener {
            schimbaActivitatea(BiografieMergeSort())
        }
    }

    // functia responsabila pentru citirea numerelor naturale si adaugarea lor in variabila numere
    private fun citesteNumere() {

        // functia split imparte textul introdus in secvente delimitate de spatiu
        // functia map aplica fiecarui element dintr-o lista o functie de tip lambda
        numere = etNumere.text.split(" ").map {
            // daca elementul nu e null
            if(it != "") {
                try {
                    // incercam sa il convertim la variabila de tip int
                    it.toInt()
                } catch (e: NumberFormatException) {
                    // intram in catch daca dam peste o eroare de tip NumberFormat Expection
                    //  adica daca elementul nu este un numar si afisam un Toast

                    Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
                    ok = false
                    -1
                }
            } else {
                -1
            }
        }.toMutableList()

        // vom sterge toate numerele de -1 din variabila numere deoarece ele reprezinta fie
        // elementul null din lista fie un element care nu a putut fi convertit la int
        numere.removeAll {
            it == -1
        }
    }


    // Functiile de sortare
    // Fiecare clasa reprezinta un tip de sortare si are 2 functii:
    // sortare - sorteaza un sir de numere in ordine crescatoare
    // updateInfo - updateaza TextView-ul respectiv metodei de sortare cu numarul de pasi
    private fun sortareInterschimbare() {
        numere1 = numere.toMutableList()
        interschimbare.sortare(numere1)
        interschimbare.updateInfo(interschimbare.counts, tvInterschimbare)
    }

    private fun sortareBule() {
        numere1 = numere.toMutableList()
        bubbleSort.sortare(numere1)
        bubbleSort.updateInfo(bubbleSort.counts, tvMetodaBulelor)
    }

    private fun sortareQuickSort() {
        numere1 = numere.toMutableList()
        quickSort.sortare(numere1)
        quickSort.updateInfo(quickSort.counts, tvQuickSort)
    }

    private fun sortareMergeSort() {
        numere1 = numere.toMutableList()
        mergeSort.sortare(numere1)
        mergeSort.updateInfo(mergeSort.counts, tvMergeSort)
    }

    // Afisam in aplicatie numarul de numere ordonate si sirul de numere ordonat
    private fun updateInfo() {
        tvCateNumere.text = "Numere selectate: ${numere.size}"
        tvNumere.text = numere1.joinToString(" ")
    }

    // functia schimbaActivitatea ne ajuta sa schimbam activitatea ea primind o activitate si
    // reuseste cu ajutorul functiei startActivity sa o schimbe
    private fun schimbaActivitatea(activitate: AppCompatActivity) {
        sterge()
        var intent = Intent(this, activitate::class.java)
        startActivity(intent)
    }

    // functie responsabila pentru stergerea numerelor si a numarului de pasi
    private fun sterge() {
        etNumere.text = null
        tvNumere.text = null
        tvCateNumere.text = null
        tvMetodaBulelor.text = null
        tvInterschimbare.text = null
        tvQuickSort.text = null
        tvMergeSort.text = null
    }

}