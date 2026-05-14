package com.example.virasatnamma.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virasatnamma.adapters.VisitAdapter
import com.example.virasatnamma.databinding.FragmentPassportBinding
import com.example.virasatnamma.viewmodel.HeritageViewModel

class PassportFragment : Fragment() {
    private var _binding: FragmentPassportBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HeritageViewModel by activityViewModels()
    private val adapter = VisitAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPassportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.visitsRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.visitsRecycler.adapter = adapter

        viewModel.visitedCount.observe(viewLifecycleOwner) { count ->
            binding.totalVisited.text = count.toString()
            binding.badgeText.text = when {
                count >= 8 -> "Royal Explorer"
                count >= 5 -> "Temple Trailblazer"
                count >= 2 -> "Heritage Beginner"
                else -> "Start your journey"
            }
        }

        viewModel.visitedSites.observe(viewLifecycleOwner) { visits ->
            adapter.submitList(visits)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
