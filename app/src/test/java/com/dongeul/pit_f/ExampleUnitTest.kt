package com.dongeul.pit_f

import android.util.Log
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals("2023-04-16","2023-04-16 12:00:00".removeDateTime())

    }
}

fun String.removeDateTime():String {
    return substring(startIndex = 0, endIndex = this.indexOf(" "))
}