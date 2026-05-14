package com.example.virasatnamma.utils

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import java.util.concurrent.atomic.AtomicBoolean

class QrAnalyzer(private val onQrDetected: (String) -> Unit) : ImageAnalysis.Analyzer {
    private val scanner = BarcodeScanning.getClient()
    private val processing = AtomicBoolean(false)

    override fun analyze(imageProxy: ImageProxy) {
        if (processing.get()) {
            imageProxy.close()
            return
        }
        val mediaImage = imageProxy.image ?: run {
            imageProxy.close()
            return
        }
        processing.set(true)
        val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
        scanner.process(image)
            .addOnSuccessListener { codes ->
                val value = codes.firstOrNull()?.rawValue
                if (!value.isNullOrBlank()) onQrDetected(value)
            }
            .addOnCompleteListener {
                processing.set(false)
                imageProxy.close()
            }
    }
}
