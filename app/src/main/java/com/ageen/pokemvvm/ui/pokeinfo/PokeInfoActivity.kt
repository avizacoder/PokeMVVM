package com.ageen.pokemvvm.ui.pokeinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.ageen.pokemvvm.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_poke_info.*

class PokeInfoActivity : AppCompatActivity() {

    lateinit var viewModel: PokeInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_info)
        viewModel = ViewModelProvider(this).get(PokeInfoViewModel::class.java)
        initUI()
    }

    private fun initUI() {
        val id = intent.extras?.get("id") as Int

        viewModel.getPokemonInfo(id)

        viewModel.pokemonInfo.observe(this, { pokemon ->
            text_info_name.text = pokemon.name
            text_info_height.text = "Height: ${pokemon.height/10.0}m"
            text_info_weight.text = "Height: ${pokemon.weight/10.0}m"

            Glide
                    .with(this)
                    .load(pokemon.sprites.frontDefault)
                    .into(image_info_name)
        })
    }
}