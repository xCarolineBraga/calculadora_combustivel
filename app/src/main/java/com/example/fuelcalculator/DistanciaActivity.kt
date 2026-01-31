package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val edtDistancia = findViewById<EditText>(R.id.edt_distancia)

        val btnProximoI = findViewById<Button>(R.id.btn_distanciaProximo)

        btnProximoI.setOnClickListener {
            var edtDistanciaValor = edtDistancia.text.toString()

            if (edtDistanciaValor.isEmpty()){
                Toast.makeText(this,R.string.mandatory_error, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var distanciaProcessada = edtDistanciaValor.toInt()

            val viagem = FichaViagem(distancia = distanciaProcessada)


            val intent = Intent(this, KmPorLitroActivity::class.java)
            intent.putExtra(FuelConstants.key.PASSWORD,viagem)
            startActivity(intent)

        }
    }
}