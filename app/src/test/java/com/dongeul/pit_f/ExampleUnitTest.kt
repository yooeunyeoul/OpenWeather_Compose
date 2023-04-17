package com.dongeul.pit_f

import android.util.Log
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals("2023-04-16", "2023-04-16 12:00:00".removeDateTime())

    }

    @Test
    fun `데이트체크`() {
        assertEquals(true, checkIsToday("2023-04-17 12:00:00".removeDateTime()))
        assertEquals(true, checkIsTomorrow("2023-04-18 12:00:00".removeDateTime()))
    }

    @Test
    fun `날짜체크`() {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val current = LocalDateTime.now().format(formatter)

        val date = LocalDate.parse("2023-04-20", formatter)

        println(date.dayOfWeek.value.getDayOfWeekString())
        println(date.dayOfMonth)
        println(date.monthValue.getMonthString())
    }

    @Test
    fun `날짜출력 해보자`() {
        val time = "2023-04-18"
        var resultText= ""
        resultText = if (checkIsToday(time)) {
            "Today"
        }else if (checkIsTomorrow(time)) {
            "Tomorrow"
        } else {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val date = LocalDate.parse("2023-04-20", formatter)

            "${date.dayOfWeek.value.getDayOfWeekString()} ${date.dayOfMonth} ${date.monthValue.getMonthString()}"
        }
        println(resultText)
    }

}

fun checkIsToday(dateTime: String): Boolean {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val current = LocalDateTime.now().format(formatter)
    return dateTime == current
}

fun checkIsTomorrow(dateTime: String): Boolean {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val current = LocalDateTime.now().plusDays(2).format(formatter)
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
    return substring(startIndex = 0, endIndex = this.indexOf(" "))
}