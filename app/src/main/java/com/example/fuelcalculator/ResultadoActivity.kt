package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val distancia = intent.getIntExtra(FuelConstants.key.DISTANCIA_ID,0)
        val kmPorLitro = intent.getIntExtra(FuelConstants.key.KM_POR_LITRO_ID,0)
        val precoCombustivel = intent.getDoubleExtra(FuelConstants.key.PRECO_COMBUSTIVEL_ID,0.0)


        val litrosNecessários = distancia / kmPorLitro
        val custoTotal = litrosNecessários * precoCombustivel
        val resultadoFinal = "%.2f".format(custoTotal)

        val distanciaFinal = findViewById<TextView>(R.id.tv_Distancia)
        val kmPorLitroFinal = findViewById<TextView>(R.id.tv_km_por_litro)
        val precoCombustivelFinal = findViewById<TextView>(R.id.tv_precoCombustível)

        distanciaFinal.text = distancia.toString()
        kmPorLitroFinal.text = kmPorLitro.toString()
        precoCombustivelFinal.text = precoCombustivel.toString()


        val tvResultado = findViewById<TextView>(R.id.tv_ResultadoCusto)

        tvResultado.text = resultadoFinal.toString()

        val litros = findViewById<TextView>(R.id.tv_LitrosNecessarios)
        
        litros.text = litrosNecessários.toString()


        val btnRecalcular = findViewById<Button>(R.id.btn_Recalcular)


        btnRecalcular.setOnClickListener {
            val intent = Intent(this, DistanciaActivity::class.java)
            startActivity(intent)
        }
    }
}