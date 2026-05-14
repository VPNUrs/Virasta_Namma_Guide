package com.example.virasatnamma.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virasatnamma.R
import com.example.virasatnamma.databinding.ItemSiteBinding
import com.example.virasatnamma.models.HeritageSite
import com.example.virasatnamma.utils.LocaleHelper

class SiteAdapter(
    private var sites: List<HeritageSite>,
    private val language: String,
    private val onClick: (HeritageSite) -> Unit
) : RecyclerView.Adapter<SiteAdapter.SiteViewHolder>() {

    inner class SiteViewHolder(val binding: ItemSiteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiteViewHolder {
        val binding = ItemSiteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SiteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SiteViewHolder, position: Int) {
        val site = sites[position]
        holder.binding.siteImage.setImageResource(R.drawable.ic_temple)
        holder.binding.siteName.text = LocaleHelper.siteText(site.nameEn, site.nameKn, language)
        holder.binding.siteDescription.text =
            LocaleHelper.siteText(site.shortDescriptionEn, site.shortDescriptionKn, language)
        holder.binding.siteDistance.text = holder.itemView.context.getString(
            R.string.distance_km_format,
            site.distanceKm
        )
        holder.binding.siteRating.text = holder.itemView.context.getString(
            R.string.rating_format,
            site.rating
        )
        holder.binding.root.setOnClickListener { onClick(site) }
    }

    override fun getItemCount(): Int = sites.size

    fun updateData(newSites: List<HeritageSite>) {
        sites = newSites
        notifyDataSetChanged()
    }
}
