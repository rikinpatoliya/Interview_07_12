package com.example.myapplication

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.time.LocalTime

class TimeOfDayGreetingTest {

    @Test
    fun testMorningGreeting() {
        // Mocking LocalTime.now() to return a time in the morning (e.g., 8 AM)
        val mockTime = mock<LocalTime>()
        whenever(mockTime.hour).thenReturn(8)

        // Test the method
        val greeting = getTimeOfDayGreeting(mockTime)
        assertEquals("Morning", greeting)
    }

    @Test
    fun testAfternoonGreeting() {
        // Mocking LocalTime.now() to return a time in the afternoon (e.g., 14 PM)
        val mockTime = mock<LocalTime>()
        whenever(mockTime.hour).thenReturn(14)

        // Test the method
        val greeting = getTimeOfDayGreeting(mockTime)
        assertEquals("Afternoon", greeting)
    }

    @Test
    fun testEveningGreeting() {
        // Mocking LocalTime.now() to return a time in the evening (e.g., 18 PM)
        val mockTime = mock<LocalTime>()
        whenever(mockTime.hour).thenReturn(18)

        // Test the method
        val greeting = getTimeOfDayGreeting(mockTime)
        assertEquals("Evening", greeting)
    }

    // The method you're testing now accepts a LocalTime parameter for easier testing
    fun getTimeOfDayGreeting(time: LocalTime): String {
        val hour = time.hour
        return when (hour) {
            in 5..11 -> "Morning"
            in 12..16 -> "Afternoon"
            else -> "Evening"
        }
    }
}
