package com.ageen.pokemvvm.ui.pokelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ageen.pokemvvm.R
import com.ageen.pokemvvm.ui.pokeinfo.PokeInfoActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PokeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init ViewModel
        viewModel = ViewModelProvider(this).get(PokeListViewModel::class.java)
        initUI()
    }

    private fun initUI() {

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokeListAdapter {
            val intent = Intent(this, PokeInfoActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)

        }

        viewModel.getPokemonList()

        //observer
        viewModel.pokemonList.observe(this, { list ->
            (recyclerView.adapter as PokeListAdapter).setData(list)
        })

    }




}