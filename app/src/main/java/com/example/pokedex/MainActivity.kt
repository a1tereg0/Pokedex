package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val main_button = findViewById<Button>(R.id.main_button);
        val response_data = findViewById<TextView>(R.id.response_data)
        main_button.setOnClickListener {
            lifecycleScope.launch {
                main_button.isEnabled = false
                response_data.text = "Loading..."
                val apiService = (application as PokedexApplication).serviceLocator.apiService
                val result = try {
                    apiService.getPokemons().results
                } catch (e: HttpException) {
                    null
                } catch (e: IOException) {
                    null
                } catch (e: Exception) {
                    null
                }

                main_button.isEnabled = true
                response_data.text = result?.toString()
            }
        }
    }
}