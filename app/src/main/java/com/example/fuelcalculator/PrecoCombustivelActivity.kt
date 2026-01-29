package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class PrecoCombustivelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco_combustivel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_precoCombustivel)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val distancia = intent.getIntExtra(FuelConstants.key.DISTANCIA_ID, 0)
        val kmPorLitro = intent.getIntExtra(FuelConstants.key.KM_POR_LITRO_ID, 0)

        val edtprecoCombustivel = findViewById<EditText>(R.id.edt_precoII)

        val btnPrecoCombustivel = findViewById<Button>(R.id.btn_PrecoCombustivelCalcular)

        btnPrecoCombustivel.setOnClickListener {

            val precoCombustivelValor = edtprecoCombustivel.text.toString().toDouble()
            val intent = Intent(this, ResultadoActivity::class.java)

            intent.putExtra(FuelConstants.key.DISTANCIA_ID, distancia)
            intent.putExtra(FuelConstants.key.KM_POR_LITRO_ID, kmPorLitro)
            intent.putExtra(FuelConstants.key.PRECO_COMBUSTIVEL_ID, precoCombustivelValor)

            startActivity(intent)

        }


    }
}