package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder

object Utils {

    private val transliterationMap = hashMapOf('а' to "a", 'б' to "b", 'в' to "v", 'г' to "g", 'д' to "d",
        'е' to "e", 'ё' to "e", 'ж' to "zh", 'з' to "z", 'и' to "i", 'й' to "i", 'к' to "k", 'л' to "l",
        'м' to "m", 'н' to "n", 'о' to "o", 'п' to "p", 'р' to "r", 'с' to "s", 'т' to "t", 'у' to "u",
        'ф' to "f", 'х' to "h", 'ц' to "c", 'ч' to "ch", 'ш' to "sh", 'щ' to "sh'", 'ъ' to "", 'ы' to "i",
        'ь' to "", 'э' to "e", 'ю' to "yu", 'я' to "ya")

    fun parseFullName(fullName: String?): Pair<String?, String?>{
        val parts = fullName?.trim()?.split(" ")
        val firstName = parts?.getOrNull(0)?.ifBlank { null }
        val lastName = parts?.getOrNull(1)?.ifBlank { null }
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val builder = StringBuilder()

        payload.trim().forEach {
            var c = transliterationMap[it.toLowerCase()] ?: it.toString()
            if (it.isUpperCase() && c.isNotBlank())
                c = c.capitalize()
            builder.append(c)
        }

        return builder.toString().replace(" ", divider)
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val nameLetter = firstName.orEmpty().trim().getOrNull(0)?.toUpperCase() ?: ""
        val surnameLetter = lastName.orEmpty().trim().getOrNull(0)?.toUpperCase() ?: ""
        return "$nameLetter$surnameLetter".ifBlank { null }
    }
}