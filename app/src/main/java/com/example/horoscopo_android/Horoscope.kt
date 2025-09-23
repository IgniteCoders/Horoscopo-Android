package com.example.horoscopo_android

data class Horoscope (
    val id: String,
    val name: Int,
    val dates: Int,
    val icon: Int
) {

    companion object {
        fun getAll() : List<Horoscope> {
            return listOf(
                Horoscope("aries", R.string.horoscope_name_aries, R.string.horoscope_date_aries, R.drawable.aries_icon),
                Horoscope("taurus", R.string.horoscope_name_taurus, R.string.horoscope_date_taurus, R.drawable.aries_icon),
                Horoscope("gemini", R.string.horoscope_name_gemini, R.string.horoscope_date_gemini, R.drawable.aries_icon),
                Horoscope("cancer", R.string.horoscope_name_cancer, R.string.horoscope_date_cancer, R.drawable.aries_icon),
                Horoscope("leo", R.string.horoscope_name_leo, R.string.horoscope_date_leo, R.drawable.aries_icon),
                Horoscope("virgo", R.string.horoscope_name_virgo, R.string.horoscope_date_virgo, R.drawable.aries_icon),
                Horoscope("libra", R.string.horoscope_name_libra, R.string.horoscope_date_libra, R.drawable.aries_icon),
                Horoscope("scorpio", R.string.horoscope_name_scorpio, R.string.horoscope_date_scorpio, R.drawable.aries_icon),
                Horoscope("sagittarius", R.string.horoscope_name_sagittarius, R.string.horoscope_date_sagittarius, R.drawable.aries_icon),
                Horoscope("capricorn", R.string.horoscope_name_capricorn, R.string.horoscope_date_capricorn, R.drawable.aries_icon),
                Horoscope("aquarius", R.string.horoscope_name_aquarius, R.string.horoscope_date_aquarius, R.drawable.aries_icon),
                Horoscope("pisces", R.string.horoscope_name_pisces, R.string.horoscope_date_pisces, R.drawable.aries_icon)
            )
        }
    }
}