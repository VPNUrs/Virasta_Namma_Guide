package com.example.virasatnamma.models

import androidx.annotation.RawRes

data class HeritageSite(
    val siteId: String,
    val nameEn: String,
    val nameKn: String,
    val shortDescriptionEn: String,
    val shortDescriptionKn: String,
    val historyEn: String,
    val historyKn: String,
    val hiddenFactEn: String,
    val hiddenFactKn: String,
    val location: String,
    val category: String,
    val distanceKm: Double,
    val rating: Double,
    val architectureStyle: String,
    val localLegends: String,
    val timings: String,
    val coordinates: String,
    @RawRes val audioResId: Int
)
