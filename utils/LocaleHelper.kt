package com.example.virasatnamma.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import java.util.Locale

object LocaleHelper {
    private const val PREFS = "virasat_prefs"
    private const val KEY_LANG = "lang"

    fun saveLanguage(context: Context, languageCode: String) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        prefs.edit().putString(KEY_LANG, languageCode).apply()
    }

    fun getLanguage(context: Context): String {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        return prefs.getString(KEY_LANG, "en") ?: "en"
    }

    fun siteText(en: String, kn: String, language: String): String {
        return if (language.lowercase(Locale.ROOT) == "kn") kn else en
    }

    fun applyAppLanguage(context: Context) {
        val lang = getLanguage(context)
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(lang))
    }
}
