package com.dongeul.pit_f.pit_f.domain.util

import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter


fun checkIsToday(dateTime: String): Boolean {
    if (dateTime.isNullOrEmpty()) {
        return false
    }
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val current = LocalDateTime.now().format(formatter)
    return dateTime == current
}

fun checkIsTomorrow(dateTime: String): Boolean {
    if (dateTime.isNullOrEmpty()) {
        return false
    }
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val current = LocalDateTime.now().plusDays(1).format(formatter)
    return dateTime == current
}

fun Int.getMonthString(): String {
    when (this) {
        1 -> {
            return "Jan"
        }
        2 -> {
            return "Feb"
        }
        3 -> {
            return "Mar"
        }
        4 -> {
            return "Apr"
        }
        5 -> {
            return "May"
        }
        6 -> {
            return "Jun"
        }
        7 -> {
            return "Jul"
        }
        8 -> {
            return "Aug"
        }
        9 -> {
            return "Sep"
        }
        10 -> {
            return "Oct"
        }
        11 -> {
            return "Nov"
        }
        12 -> {
            return "Dec"
        }
        else -> {
            return "None"
        }

    }
}

fun Int.getDayOfWeekString(): String {
    when (this) {
        1 -> {
            return "Sun"
        }
        2 -> {
            return "Mon"
        }
        3 -> {
            return "Tue"
        }
        4 -> {
            return "Wed"
        }
        5 -> {
            return "Thu"
        }
        6 -> {
            return "Fri"
        }
        7 -> {
            return "Sat"
        }
        else -> {
            return "None"
        }
    }
}

fun String.removeDateTime(): String {
    if (this.isNullOrEmpty()) {
        return "nullOrEmpty"
    }
    return substring(startIndex = 0, endIndex = this.indexOf(" "))
}

fun getDisplayDate(date: String): String {
    if (date.isNullOrEmpty()) {
        return "dateIsNullOrEmpty"
    }
    return if (checkIsToday(date)) {
        "Today"
    } else if (checkIsTomorrow(date)) {
        "Tomorrow"
    } else {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(date, formatter)
        "${date.dayOfWeek.value.getDayOfWeekString()} ${date.dayOfMonth} ${date.monthValue.getMonthString()}"
    }
}
