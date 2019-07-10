package ru.skillbranch.devintensive.utils

import java.util.*

val translateMap: Map<String, String> = mapOf(
    "а" to "a",
    "б" to "b",
    "в" to "v",
    "г" to "g",
    "д" to "d",
    "е" to "e",
    "ё" to "e",
    "ж" to "zh",
    "з" to "z",
    "и" to "i",
    "й" to "i",
    "к" to "k",
    "л" to "l",
    "м" to "m",
    "н" to "n",
    "о" to "o",
    "п" to "p",
    "р" to "r",
    "с" to "s",
    "т" to "t",
    "у" to "u",
    "ф" to "f",
    "х" to "h",
    "ц" to "c",
    "ч" to "ch",
    "ш" to "sh",
    "щ" to "sh'",
    "ъ" to "",
    "ы" to "i",
    "ь" to "",
    "э" to "e",
    "ю" to "yu",
    "я" to "ya"
)

object Utils {

    fun parseFullName(fullName:String?):Pair<String?, String?> {
        val parts : List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0) ?: "null"
        var lastName = parts?.getOrNull(1) ?: "null"

        if (firstName == "") {
            firstName = "null"
        }
        if (lastName == "") {
            lastName = "null"
        }

        return Pair(firstName, lastName)
        //return firstName to lastName
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var first: String = firstName ?: ""
        var second: String = lastName ?: ""
        var result: String?

        first = first.trim().take(1)
        second = second.trim().take(1)

        result = (first + second).toUpperCase(Locale("ru"))

        if (result == "") {
            result = null
        }

        return result
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val builder = StringBuilder()

        for (letter in payload) {
            val word = letter.toString()
            var w: String?

            if (word == " ") {
                w = divider
            } else if (translateMap[word] != null) {
                w = translateMap[word]
            } else if (translateMap[word.toLowerCase()] != null) {
                w = translateMap[word.toLowerCase()]?.capitalize()
            } else {
                w = word
            }

            builder.append(w)
        }

        return builder.toString()
    }

}