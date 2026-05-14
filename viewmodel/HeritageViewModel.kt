package com.example.virasatnamma.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.virasatnamma.database.AppDatabase
import com.example.virasatnamma.models.HeritageSite
import com.example.virasatnamma.models.VisitEntity
import com.example.virasatnamma.repository.HeritageRepository
import kotlinx.coroutines.launch

class HeritageViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = HeritageRepository(AppDatabase.getDatabase(application).visitDao())
    val allSites: List<HeritageSite> = repository.allSites
    val visitedSites = repository.visitedSites
    val favoriteSites = repository.favoriteSites
    val visitedCount = repository.visitedCount
    private val _selectedSite = MutableLiveData<HeritageSite?>()
    val selectedSite: LiveData<HeritageSite?> = _selectedSite

    fun selectSite(site: HeritageSite) {
        _selectedSite.value = site
    }

    fun selectSiteById(siteId: String): HeritageSite? {
        val site = repository.getSiteById(siteId)
        _selectedSite.value = site
        return site
    }

    fun getVisitBySiteId(siteId: String): LiveData<VisitEntity?> = repository.getVisitBySiteId(siteId)

    fun checkInCurrentSite() {
        _selectedSite.value?.let { site ->
            viewModelScope.launch { repository.checkInSite(site) }
        }
    }

    fun toggleFavorite(current: VisitEntity?) {
        _selectedSite.value?.let { site ->
            viewModelScope.launch { repository.toggleFavorite(site, current) }
        }
    }
}
