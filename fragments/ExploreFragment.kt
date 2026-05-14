package com.example.virasatnamma.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.virasatnamma.R
import com.example.virasatnamma.databinding.FragmentExploreBinding
import com.example.virasatnamma.utils.QrAnalyzer
import com.example.virasatnamma.viewmodel.HeritageViewModel
import java.util.concurrent.Executors

class ExploreFragment : Fragment() {
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HeritageViewModel by activityViewModels()
    private val cameraExecutor = Executors.newSingleThreadExecutor()

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) startCamera() else Toast.makeText(
                requireContext(),
                getString(R.string.camera_permission_required),
                Toast.LENGTH_SHORT
            ).show()
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            startCamera()
        } else {
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(binding.previewView.surfaceProvider)
            }

            val analyzer = ImageAnalysis.Builder().build().also {
                it.setAnalyzer(cameraExecutor, QrAnalyzer { rawValue ->
                    activity?.runOnUiThread {
                        val site = viewModel.selectSiteById(rawValue.trim())
                        if (site != null) {
                            Toast.makeText(requireContext(), getString(R.string.hidden_fact_unlocked), Toast.LENGTH_LONG).show()
                            findNavController().navigate(R.id.action_exploreFragment_to_siteDetailsFragment)
                        } else {
                            Toast.makeText(requireContext(), getString(R.string.invalid_qr), Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(viewLifecycleOwner, cameraSelector, preview, analyzer)
            } catch (_: Exception) {
                Toast.makeText(requireContext(), getString(R.string.qr_failed), Toast.LENGTH_SHORT).show()
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cameraExecutor.shutdown()
        _binding = null
    }
}
