package com.example.virasatnamma.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.virasatnamma.databinding.FragmentProfileBinding
import com.example.virasatnamma.viewmodel.HeritageViewModel

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HeritageViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.visitedCount.observe(viewLifecycleOwner) { count ->
            binding.sitesVisitedValue.text = count.toString()
            binding.heritageScoreValue.text = (count * 120).toString()
            binding.passportProgressValue.text = "${(count * 10).coerceAtMost(100)}%"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
