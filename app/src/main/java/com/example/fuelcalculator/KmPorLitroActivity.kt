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

class KmPorLitroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_km_por_litro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_kmPorLitro)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val distancia = intent.getIntExtra(FuelConstants.key.DISTANCIA_ID, 0)

        val edtKmLitro = findViewById<EditText>(R.id.edt_kmPorLitro)
        val btnProximoII = findViewById<Button>(R.id.btn_KmPorLitroProximo)

        btnProximoII.setOnClickListener {
            val kmPorLitroValor = edtKmLitro.text.toString().toInt()

            val intent = Intent(this, PrecoCombustivelActivity::class.java)

            intent.putExtra(FuelConstants.key.DISTANCIA_ID, distancia)
            intent.putExtra(FuelConstants.key.KM_POR_LITRO_ID, kmPorLitroValor)

            startActivity(intent)
        }
    }
}