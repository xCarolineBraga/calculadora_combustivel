package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
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
        val viagemCompleta = IntentCompat.getParcelableExtra(intent, FuelConstants.key.PASSWORD,
            FichaViagem::class.java)


        val distanciaFinal = findViewById<TextView>(R.id.tv_Distancia)
        val kmPorLitroFinal = findViewById<TextView>(R.id.tv_km_por_litro)
        val precoCombustivelFinal = findViewById<TextView>(R.id.tv_precoCombustível)
        val tvResultado = findViewById<TextView>(R.id.tv_ResultadoCusto)
        val litros = findViewById<TextView>(R.id.tv_LitrosNecessarios)


        viagemCompleta?.let{
            val distancia = it.distancia
            val kmPorLitro = it.consumo
            val precoCombustivel = it.preco

            val litrosNecessarios = distancia / kmPorLitro
            val custoTotal = litrosNecessarios * precoCombustivel


            distanciaFinal.text = distancia.toString()
            kmPorLitroFinal.text = kmPorLitro.toString()
            precoCombustivelFinal.text = precoCombustivel.toString()

            litros.text = litrosNecessarios.toString()
            tvResultado.text = "R$ %.2f".format(custoTotal)
        }

        val btnRecalcular = findViewById<Button>(R.id.btn_Recalcular)


        btnRecalcular.setOnClickListener {
            val intent = Intent(this, DistanciaActivity::class.java)
            startActivity(intent)
        }
    }
}