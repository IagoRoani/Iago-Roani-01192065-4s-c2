package com.example.avaliaocontinuada2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SucessoEncontrar : AppCompatActivity() {

    lateinit var tvCachorro1 : TextView
    lateinit var tvCachorro2 : TextView
    lateinit var tvTotalCompra : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sucesso_encontrar)

        val raca = intent.getStringExtra("raca")
        val precoMedio = intent.getIntExtra("precoMedio", 0)

        val raca2 = intent.getStringExtra("raca2")
        val precoMedio2 = intent.getIntExtra("precoMedio2", 0)

        val totalCompra = precoMedio + precoMedio2

        tvCachorro1 = findViewById(R.id.tv_raca_cachorro1)
        tvCachorro2 = findViewById(R.id.tv_raca_cachorro2)
        tvTotalCompra = findViewById(R.id.tv_valor_compra)

        tvCachorro1.text = "$raca"
        tvCachorro2.text = "$raca2"
        tvTotalCompra.text = "${totalCompra.toString()}"


    }
}