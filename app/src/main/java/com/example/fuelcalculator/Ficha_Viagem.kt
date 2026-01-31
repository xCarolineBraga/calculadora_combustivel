package com.example.fuelcalculator

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize

data class FichaViagem(
    var distancia: Int = 0,
    var consumo: Int = 0,
    var preco: Double = 0.0

): Parcelable
