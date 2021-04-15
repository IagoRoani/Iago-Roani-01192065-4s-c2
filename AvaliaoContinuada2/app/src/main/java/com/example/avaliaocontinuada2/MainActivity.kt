package com.example.avaliaocontinuada2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var btnComprar : Button
    lateinit var swSeguranca : Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnComprar = findViewById(R.id.btn_comprar)
        swSeguranca = findViewById(R.id.sw_seguranca)

    }

    fun resultado(view: View) {

        if (swSeguranca.isChecked){
            val telaSucesso = Intent(this, SucessoEncontrar::class.java)
            startActivity(telaSucesso)

            val apiCachorros = ConexaoApiCachorros.criar()

            apiCachorros.get().enqueue(object : Callback<List<Cachorro>> {

                // onResponse é executando se chamada for feita com sucesso
                override fun onResponse(call: Call<List<Cachorro>>, response: Response<List<Cachorro>>) {

                }

                // onFailure é executado se houver erro na chamada
                override fun onFailure(call: Call<List<Filme>>, t: Throwable) {
                    Log.e("api", t.message!!)
                    // t.printStackTrace()
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                }
            })

        }

        if (!swSeguranca.isChecked){

        }

    }
}