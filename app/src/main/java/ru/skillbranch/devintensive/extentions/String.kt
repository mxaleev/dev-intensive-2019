package ru.skillbranch.devintensive.extensions

fun String.truncate(length: Int = 16): String{
    val trimmed = this.trim()
    return if (trimmed.length <= length)
        trimmed
    else
        trimmed.substring(0, length).trim() + "..."
}

fun String.stripHtml() = this.replace(Regex("(<.*?>)|(&[^ а-я]{1,4}?;)"), "").replace(Regex("\\s+"), " ")