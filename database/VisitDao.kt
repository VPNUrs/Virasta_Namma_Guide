package com.example.virasatnamma.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.virasatnamma.models.VisitEntity

@Dao
interface VisitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertVisit(visit: VisitEntity)

    @Query("SELECT * FROM visits ORDER BY visitTimestamp DESC")
    fun getAllVisits(): LiveData<List<VisitEntity>>

    @Query("SELECT * FROM visits WHERE isVisited = 1 ORDER BY visitTimestamp DESC")
    fun getVisitedSites(): LiveData<List<VisitEntity>>

    @Query("SELECT * FROM visits WHERE isFavorite = 1")
    fun getFavoriteSites(): LiveData<List<VisitEntity>>

    @Query("SELECT COUNT(*) FROM visits WHERE isVisited = 1")
    fun getVisitedCount(): LiveData<Int>

    @Query("SELECT * FROM visits WHERE siteId = :siteId LIMIT 1")
    fun getVisitBySiteId(siteId: String): LiveData<VisitEntity?>
}
