package com.example.virasatnamma.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virasatnamma.R
import com.example.virasatnamma.adapters.SiteAdapter
import com.example.virasatnamma.databinding.FragmentHomeBinding
import com.example.virasatnamma.utils.LocaleHelper
import com.example.virasatnamma.viewmodel.HeritageViewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HeritageViewModel by activityViewModels()
    private lateinit var adapter: SiteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val language = LocaleHelper.getLanguage(requireContext())

        adapter = SiteAdapter(viewModel.allSites, language) { site ->
            viewModel.selectSite(site)
            findNavController().navigate(R.id.action_homeFragment_to_siteDetailsFragment)
        }
        binding.sitesRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.sitesRecycler.adapter = adapter

        binding.languageToggle.isChecked = language == "kn"
        binding.languageToggle.setOnCheckedChangeListener { _, checked ->
            LocaleHelper.saveLanguage(requireContext(), if (checked) "kn" else "en")
            requireActivity().recreate()
        }

        binding.searchLayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
            override fun afterTextChanged(s: Editable?) {
                val query = s?.toString()?.trim()?.lowercase().orEmpty()
                val filtered = if (query.isBlank()) viewModel.allSites else viewModel.allSites.filter {
                    it.nameEn.lowercase().contains(query) || it.nameKn.contains(query)
                }
                adapter.updateData(filtered)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
