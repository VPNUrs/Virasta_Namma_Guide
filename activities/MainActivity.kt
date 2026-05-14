package com.example.virasatnamma.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.virasatnamma.R
import com.example.virasatnamma.databinding.ActivityMainBinding
import com.example.virasatnamma.utils.LocaleHelper
import com.example.virasatnamma.viewmodel.HeritageViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val heritageViewModel: HeritageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        LocaleHelper.applyAppLanguage(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment)
        binding.bottomNav.setupWithNavController(navController)
    }
}
