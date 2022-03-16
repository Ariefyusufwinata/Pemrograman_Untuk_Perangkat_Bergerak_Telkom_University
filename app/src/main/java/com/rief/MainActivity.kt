package com.rief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rief.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //This for logging list data of animals
        //Log.d("Data To Main", "The mount of data is ${getData().size}")

        //This binding added from layout activity with id recycler
        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            //This For Implement Grid Layout
            //layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = MainAdapter(getData())
            setHasFixedSize(true)
        }
    }

    private fun getData(): List<Hewan> {
        return listOf(
            Hewan("Angsa","Unggas", "Cygnus olor", R.drawable.angsa),
            Hewan("Ayam","Unggas", "Gallus gallus", R.drawable.ayam),
            Hewan("Bebek","Unggas", "Cairina moschata", R.drawable.bebek),
            Hewan("Domba","Mamalia", "Ovis ammon", R.drawable.domba),
            Hewan("Kalkun","Unggas", "Meleagris gallopavo", R.drawable.kalkun),
            Hewan("Kambing","Mamalia", "Capricornis sumatrensis", R.drawable.kambing),
            Hewan("Kelinci","Mamalia", "Oryctolagus cuniculus", R.drawable.kelinci),
            Hewan("Kerbau","Mamalia", "Bubalus bubalis", R.drawable.kerbau),
            Hewan("Kuda","Mamalia", "Equus caballus", R.drawable.kuda),
            Hewan("Sapi","Mamalia", "Bos taurus", R.drawable.sapi),

        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(Menu.NONE, 1, Menu.NONE, "Linear Layout")
        menu?.add(Menu.NONE, 2, Menu.NONE, "Grid Layout")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            1 ->
                with(binding.recyclerView) {
                    addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = MainAdapter(getData())
                    setHasFixedSize(true)
                }
            2 ->
                with(binding.recyclerView) {
                    addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
                    layoutManager = GridLayoutManager(this@MainActivity, 2)
                    adapter = GridAdapter(getData())
                    setHasFixedSize(true)
                }
        }
        return super.onOptionsItemSelected(item)
    }
}