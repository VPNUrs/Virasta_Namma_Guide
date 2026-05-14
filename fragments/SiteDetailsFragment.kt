package com.example.virasatnamma.fragments

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.virasatnamma.R
import com.example.virasatnamma.databinding.FragmentSiteDetailsBinding
import com.example.virasatnamma.models.VisitEntity
import com.example.virasatnamma.utils.LocaleHelper
import com.example.virasatnamma.viewmodel.HeritageViewModel

class SiteDetailsFragment : Fragment() {
    private var _binding: FragmentSiteDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HeritageViewModel by activityViewModels()
    private var mediaPlayer: MediaPlayer? = null
    private var currentVisit: VisitEntity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSiteDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val site = viewModel.selectedSite.value ?: return
        val language = LocaleHelper.getLanguage(requireContext())

        binding.siteImageBanner.setImageResource(R.drawable.ic_temple)
        binding.siteTitle.text = LocaleHelper.siteText(site.nameEn, site.nameKn, language)
        binding.siteLocation.text = site.location
        binding.siteHistory.text = LocaleHelper.siteText(site.historyEn, site.historyKn, language)
        binding.siteArchitecture.text = site.architectureStyle
        binding.siteLegends.text = site.localLegends
        binding.siteTimings.text = site.timings
        binding.hiddenFactText.text = LocaleHelper.siteText(site.hiddenFactEn, site.hiddenFactKn, language)
        binding.mapPreview.text = getString(R.string.map_preview, site.coordinates)

        viewModel.getVisitBySiteId(site.siteId).observe(viewLifecycleOwner) {
            currentVisit = it
            binding.visitedBadge.visibility = if (it?.isVisited == true) View.VISIBLE else View.GONE
            binding.favoriteButton.text = if (it?.isFavorite == true) getString(R.string.unfavorite) else getString(R.string.favorite)
        }

        binding.checkInButton.setOnClickListener {
            viewModel.checkInCurrentSite()
            Toast.makeText(requireContext(), getString(R.string.checked_in), Toast.LENGTH_SHORT).show()
        }
        binding.favoriteButton.setOnClickListener {
            viewModel.toggleFavorite(currentVisit)
        }
        binding.shareButton.setOnClickListener {
            val text = "${site.nameEn} - ${site.historyEn}"
            startActivity(Intent.createChooser(Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, text)
                type = "text/plain"
            }, getString(R.string.share_site)))
        }

        binding.aiLegendButton.setOnClickListener {
            binding.aiLegendCard.visibility = View.VISIBLE
            binding.aiLegendText.text = getString(R.string.ai_legend_template, site.nameEn)
        }

        binding.playAudioButton.setOnClickListener { playAudio(site.audioResId) }
        binding.pauseAudioButton.setOnClickListener { mediaPlayer?.pause() }
        binding.stopAudioButton.setOnClickListener {
            mediaPlayer?.stop()
            releasePlayer()
        }
    }

    private fun playAudio(audioRes: Int) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(requireContext(), audioRes)
        }
        try {
            mediaPlayer?.start()
        } catch (_: IllegalStateException) {
            releasePlayer()
            Toast.makeText(requireContext(), getString(R.string.audio_error), Toast.LENGTH_SHORT).show()
        }
    }

    private fun releasePlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        releasePlayer()
        _binding = null
    }
}
