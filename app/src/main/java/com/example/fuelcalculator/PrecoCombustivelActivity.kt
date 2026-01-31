package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
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

        val viagem = IntentCompat.getParcelableExtra(intent, FuelConstants.key.PASSWORD,
            FichaViagem::class.java)

//        val distancia = intent.getIntExtra(FuelConstants.key.PASSWORD, 0)
//        val kmPorLitro = intent.getIntExtra(FuelConstants.key.KM_POR_LITRO_ID, 0)

        val edtprecoCombustivel = findViewById<EditText>(R.id.edt_precoII)

        val btnPrecoCombustivel = findViewById<Button>(R.id.btn_PrecoCombustivelCalcular)

        btnPrecoCombustivel.setOnClickListener {

            val preco = edtprecoCombustivel.text.toString()

            if (preco.isEmpty()){
                Toast.makeText(this,R.string.mandatory_error, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viagem?.let {
                it.preco = edtprecoCombustivel.text.toString().toDouble()

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra(FuelConstants.key.PASSWORD,it)
                startActivity(intent)
            }



        }


    }
}