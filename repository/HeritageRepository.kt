package com.example.virasatnamma.repository

import androidx.lifecycle.LiveData
import com.example.virasatnamma.database.VisitDao
import com.example.virasatnamma.models.HeritageSite
import com.example.virasatnamma.models.VisitEntity
import com.example.virasatnamma.utils.DummyDataProvider

class HeritageRepository(private val visitDao: VisitDao) {
    val allSites: List<HeritageSite> = DummyDataProvider.getSites()
    val visitedSites: LiveData<List<VisitEntity>> = visitDao.getVisitedSites()
    val favoriteSites: LiveData<List<VisitEntity>> = visitDao.getFavoriteSites()
    val visitedCount: LiveData<Int> = visitDao.getVisitedCount()

    fun getSiteById(siteId: String): HeritageSite? = allSites.find { it.siteId == siteId }

    fun getVisitBySiteId(siteId: String): LiveData<VisitEntity?> = visitDao.getVisitBySiteId(siteId)

    suspend fun checkInSite(site: HeritageSite) {
        visitDao.upsertVisit(
            VisitEntity(
                siteId = site.siteId,
                siteName = site.nameEn,
                isVisited = true,
                isFavorite = false
            )
        )
    }

    suspend fun toggleFavorite(site: HeritageSite, current: VisitEntity?) {
        val updated = VisitEntity(
            siteId = site.siteId,
            siteName = site.nameEn,
            isVisited = current?.isVisited ?: false,
            isFavorite = !(current?.isFavorite ?: false),
            visitTimestamp = current?.visitTimestamp ?: System.currentTimeMillis()
        )
        visitDao.upsertVisit(updated)
    }
}
