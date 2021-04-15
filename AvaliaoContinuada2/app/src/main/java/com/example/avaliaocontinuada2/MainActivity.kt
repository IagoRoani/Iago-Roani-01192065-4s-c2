package com.example.avaliaocontinuada2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var btnComprar : Button
    lateinit var swSeguranca : Switch
    lateinit var edCachorro1 : EditText
    lateinit var edCachorro2 : EditText
    val apiCachorros = ConexaoApiCachorros.criar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnComprar = findViewById(R.id.btn_comprar)
        swSeguranca = findViewById(R.id.sw_seguranca)
        edCachorro1 = findViewById(R.id.primeiro_numero)
        edCachorro2 = findViewById(R.id.segundo_numero)

    }

    fun resultado(view: View) {
        val cachorro1 : Cachorro
        val cachorro2 : Cachorro

        val id1 = edCachorro1.text.toString().toInt()
        val id2 = edCachorro2.text.toString().toInt()

        val telaSucesso = Intent(this, SucessoEncontrar::class.java)



        if (swSeguranca.isChecked){

            apiCachorros.get(id2).enqueue(object : Callback<Cachorro> {
                override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                    val cachorro = response.body()
                    if (cachorro != null && cachorro.indicadoCriancas == true) {
                        telaSucesso.putExtra("raca", "${cachorro.raca}")
                        telaSucesso.putExtra("precoMedio", cachorro.precoMedio)
                        telaSucesso.putExtra("indicadoCrianca", cachorro.indicadoCriancas)
                    } else {
                        telaSucesso.putExtra("naoEncontrado", "não encontrado")
                    }
                }

                override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

            apiCachorros.get(id1).enqueue(object : Callback<Cachorro> {
                override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                    val cachorro = response.body()
                    if (cachorro != null && cachorro.indicadoCriancas == true) {
                        telaSucesso.putExtra("raca", "${cachorro.raca}")
                        telaSucesso.putExtra("precoMedio", cachorro.precoMedio)
                        telaSucesso.putExtra("indicadoCrianca", cachorro.indicadoCriancas)
                    } else {
                        telaSucesso.putExtra("naoEncontrado", "não encontrado")
                    }
                }

                override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

            startActivity(telaSucesso)

        }


        if (!swSeguranca.isChecked){

            apiCachorros.get(id2).enqueue(object : Callback<Cachorro> {
                override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                    val cachorro2 = response.body()
                    if (cachorro2 != null) {
                        telaSucesso.putExtra("raca", "${cachorro2.raca}")
                        telaSucesso.putExtra("precoMedio", cachorro2.precoMedio)
                        telaSucesso.putExtra("indicadoCrianca", cachorro2.indicadoCriancas)
                    } else {
                        telaSucesso.putExtra("naoEncontrado", "não encontrado")
                    }
                }

                override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

            apiCachorros.get(id1).enqueue(object : Callback<Cachorro> {
                override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                    val cachorro = response.body()
                    if (cachorro != null) {
                        telaSucesso.putExtra("raca", "${cachorro.raca}")
                        telaSucesso.putExtra("precoMedio", cachorro.precoMedio)
                        telaSucesso.putExtra("indicadoCrianca", cachorro.indicadoCriancas)
                    } else {
                        telaSucesso.putExtra("naoEncontrado", "não encontrado")
                    }
                }

                override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

            startActivity(telaSucesso)

        }

        if (id1 < 0 || id1 > 100 || id2 < 0 || id2 > 100){
            val telaFalha = Intent(this, FalhaEncontrar::class.java)
            startActivity(telaFalha)
        }

    }
}