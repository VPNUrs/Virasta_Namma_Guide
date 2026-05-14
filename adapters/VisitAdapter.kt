package com.example.virasatnamma.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virasatnamma.databinding.ItemVisitBinding
import com.example.virasatnamma.models.VisitEntity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class VisitAdapter : RecyclerView.Adapter<VisitAdapter.VisitViewHolder>() {
    private var visits: List<VisitEntity> = emptyList()

    inner class VisitViewHolder(val binding: ItemVisitBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitViewHolder {
        val binding = ItemVisitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VisitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VisitViewHolder, position: Int) {
        val visit = visits[position]
        holder.binding.visitSiteName.text = visit.siteName
        holder.binding.visitStatus.text = if (visit.isVisited) "Visited" else "Planned"
        val format = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())
        holder.binding.visitTime.text = format.format(Date(visit.visitTimestamp))
    }

    override fun getItemCount(): Int = visits.size

    fun submitList(data: List<VisitEntity>) {
        visits = data
        notifyDataSetChanged()
    }
}
