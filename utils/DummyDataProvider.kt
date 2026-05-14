package com.example.virasatnamma.utils

import com.example.virasatnamma.R
import com.example.virasatnamma.models.HeritageSite

object DummyDataProvider {
    fun getSites(): List<HeritageSite> = listOf(
        site("SITE_101", "Hampi", "ಹಂಪಿ", "UNESCO ruins of Vijayanagara Empire", "ವಿಜಯನಗರ ಸಾಮ್ರಾಜ್ಯದ ಯುನೆಸ್ಕೊ ಅವಶೇಷಗಳು", "Hampi was the royal capital of Vijayanagara.", "ಹಂಪಿ ವಿಜಯನಗರದ ರಾಜಧಾನಿಯಾಗಿತ್ತು.", "Musical pillars in Vittala temple produce unique tones.", "ವಿಟ್ಟಲ ದೇವಾಲಯದ ಸಂಗೀತ ಸ್ತಂಭಗಳು ವಿಶಿಷ್ಟ ಧ್ವನಿ ಕೊಡುತ್ತವೆ.", "Vijayanagara, Karnataka", "Temples", 4.2, 4.8),
        site("SITE_102", "Belur Temple", "ಬೆಳೂರು ದೇವಾಲಯ", "Intricate Hoysala architecture", "ಸೂಕ್ಷ್ಮ ಹೊಯ್ಸಳ ಶೈಲಿ ವಾಸ್ತುಶಿಲ್ಪ", "Chennakesava Temple was built in 12th century.", "ಚೆನ್ನಕೇಶವ ದೇವಾಲಯ 12ನೇ ಶತಮಾನದಲ್ಲಿ ನಿರ್ಮಿತವಾಗಿದೆ.", "Soapstone carvings show stories from epics.", "ಸೋಪ್‌ಸ್ಟೋನ್ ಶಿಲ್ಪಗಳಲ್ಲಿ ಪುರಾಣ ಕಥೆಗಳು ಕಾಣುತ್ತವೆ.", "Belur, Hassan", "Temples", 8.4, 4.7),
        site("SITE_103", "Halebidu", "ಹಳೆಬೀಡು", "Ancient Hoysala capital", "ಪ್ರಾಚೀನ ಹೊಯ್ಸಳ ರಾಜಧಾನಿ", "Halebidu preserves Hoysaleswara temple complex.", "ಹಳೆಬೀಡು ಹೊಯ್ಸಳೇಶ್ವರ ದೇವಾಲಯ ಸಂಕೀರ್ಣವನ್ನು ಉಳಿಸಿದೆ.", "Temple walls depict thousands of sculptures.", "ದೇವಾಲಯದ ಗೋಡೆಗಳಲ್ಲಿ ಸಾವಿರಾರು ಶಿಲ್ಪಗಳಿವೆ.", "Halebidu, Hassan", "Temples", 12.3, 4.6),
        site("SITE_104", "Badami Caves", "ಬಾದಾಮಿ ಗುಹೆಗಳು", "Rock-cut cave temples", "ಶಿಲಾ ಕತ್ತರಿಸಿದ ಗುಹಾ ದೇವಾಲಯಗಳು", "Badami caves reflect Chalukyan artistry.", "ಬಾದಾಮಿ ಗುಹೆಗಳು ಚಾಲುಕ್ಯ ಕಲೆಯನ್ನು ತೋರಿಸುತ್ತವೆ.", "Caves include Hindu and Jain monuments.", "ಗುಹೆಗಳಲ್ಲಿ ಹಿಂದೂ ಮತ್ತು ಜೈನ ಸ್ಮಾರಕಗಳಿವೆ.", "Badami, Bagalkot", "Inscriptions", 16.1, 4.7),
        site("SITE_105", "Pattadakal", "ಪಟ್ಟದಕಲ್ಲು", "Coronation and temple town", "ರಾಜಾಭಿಷೇಕ ಮತ್ತು ದೇವಾಲಯ ಪಟ್ಟಣ", "Pattadakal hosted Chalukya coronations.", "ಪಟ್ಟದಕಲ್ಲು ಚಾಲುಕ್ಯರ ರಾಜಾಭಿಷೇಕ ಕೇಂದ್ರವಾಗಿತ್ತು.", "Blend of Nagara and Dravidian styles.", "ನಗರ ಮತ್ತು ದ್ರಾವಿಡ ಶೈಲಿಗಳ ಸಂಯೋಜನೆ ಇದೆ.", "Pattadakal, Bagalkot", "Temples", 9.8, 4.6),
        site("SITE_106", "Mysore Palace", "ಮೈಸೂರು ಅರಮನೆ", "Royal palace with Indo-Saracenic design", "ಇಂಡೋ-ಸರಸಿನಿಕ್ ಶೈಲಿಯ ರಾಜ ಅರಮನೆ", "The Wadiyar dynasty resided here.", "ವಾಡಿಯಾರ್ ವಂಶ ಇಲ್ಲಿ ವಾಸವಿತ್ತು.", "Palace glows with thousands of lights on Sundays.", "ಭಾನುವಾರ ಅರಮನೆ ಸಾವಿರಾರು ದೀಪಗಳಿಂದ ಹೊಳೆಯುತ್ತದೆ.", "Mysuru", "Museums", 2.5, 4.9),
        site("SITE_107", "Shravanabelagola", "ಶ್ರವಣಬೆಳಗೊಳ", "Jain pilgrimage hill", "ಜೈನ ತೀರ್ಥಯಾತ್ರಾ ಬೆಟ್ಟ", "Known for Gommateshwara monolith statue.", "ಗೊಮ್ಮಟೇಶ್ವರ ಏಕಶಿಲಾ ಮೂರ್ತಿಗಾಗಿ ಪ್ರಸಿದ್ಧ.", "Mahamastakabhisheka festival happens every 12 years.", "ಮಹಾಮಸ್ತಕಾಭಿಷೇಕ ಪ್ರತಿ 12 ವರ್ಷಕ್ಕೊಮ್ಮೆ ನಡೆಯುತ್ತದೆ.", "Hassan district", "Hidden Villages", 20.0, 4.5),
        site("SITE_108", "Aihole", "ಐಹೊಳೆ", "Cradle of temple architecture", "ದೇವಾಲಯ ವಾಸ್ತುಶಿಲ್ಪದ ತೊಟ್ಟಿಲು", "Aihole has over 100 temples.", "ಐಹೊಳೆಯಲ್ಲಿ 100ಕ್ಕೂ ಹೆಚ್ಚು ದೇವಾಲಯಗಳಿವೆ.", "Durga temple has unique apsidal plan.", "ದುರ್ಗಾ ದೇವಾಲಯದ ವಿನ್ಯಾಸ ವಿಶಿಷ್ಟವಾಗಿದೆ.", "Aihole, Bagalkot", "Temples", 14.9, 4.5),
        site("SITE_109", "Bidar Fort", "ಬೀದರ್ ಕೋಟೆ", "Massive Bahmani era fort", "ಬಹಮನಿ ಕಾಲದ ಭವ್ಯ ಕೋಟೆ", "Bidar Fort served strategic defense.", "ಬೀದರ್ ಕೋಟೆ ತಂತ್ರಾತ್ಮಕ ರಕ್ಷಣೆಗೆ ಸೇವೆ ಸಲ್ಲಿಸಿತು.", "Rangin Mahal has exquisite wood inlay.", "ರಂಗೀನ್ ಮಹಲ್‌ನಲ್ಲಿ ಸುಂದರ ಮರದ ಅಲಂಕಾರ ಇದೆ.", "Bidar", "Forts", 28.5, 4.4),
        site("SITE_110", "Somanathapura", "ಸೋಮನಾಥಪುರ", "Keshava temple masterpiece", "ಕೇಶವ ದೇವಾಲಯದ ಅಚ್ಚರಿ ಕಲೆ", "Built under Hoysala general Somanatha.", "ಹೊಯ್ಸಳ ಸೇನಾನಿ ಸೋಮನಾಥನ ಕಾಲದಲ್ಲಿ ನಿರ್ಮಾಣ.", "Temple star-shaped platform is iconic.", "ದೇವಾಲಯದ ನಕ್ಷತ್ರಾಕೃತಿ ವೇದಿ ಪ್ರಸಿದ್ಧ.", "Mysuru district", "Temples", 11.4, 4.6)
    )

    private fun site(
        id: String,
        nameEn: String,
        nameKn: String,
        shortEn: String,
        shortKn: String,
        historyEn: String,
        historyKn: String,
        hiddenEn: String,
        hiddenKn: String,
        location: String,
        category: String,
        distance: Double,
        rating: Double
    ): HeritageSite = HeritageSite(
        siteId = id,
        nameEn = nameEn,
        nameKn = nameKn,
        shortDescriptionEn = shortEn,
        shortDescriptionKn = shortKn,
        historyEn = historyEn,
        historyKn = historyKn,
        hiddenFactEn = hiddenEn,
        hiddenFactKn = hiddenKn,
        location = location,
        category = category,
        distanceKm = distance,
        rating = rating,
        architectureStyle = "Dravidian / Hoysala",
        localLegends = "Locals believe divine guardians still protect this site.",
        timings = "6:00 AM - 6:00 PM",
        coordinates = "12.0, 76.0",
        audioResId = R.raw.sample_audio
    )
}
