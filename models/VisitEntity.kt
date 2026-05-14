package com.example.virasatnamma.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "visits")
data class VisitEntity(
    @PrimaryKey val siteId: String,
    val siteName: String,
    val isVisited: Boolean = true,
    val isFavorite: Boolean = false,
    val visitTimestamp: Long = System.currentTimeMillis()
)
