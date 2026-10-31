package com.example.myapplication

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeRule = createComposeRule()

    private val addWaterButton: SemanticsNodeInteraction
        get() = composeRule.onNodeWithText("+250 мл")

    private val endDayButton: SemanticsNodeInteraction
        get() = composeRule.onNodeWithText("Завершить день")

    @Before
    fun setUp() {
        composeRule.setContent {
            MaterialTheme {
                WaterTracker()
            }
        }
    }

    @Test
    fun initialState_displaysButtonsAndZeroCounters() {
        addWaterButton.assertIsDisplayed()
        endDayButton.assertIsDisplayed()
        assertWaterAmount(0)
        assertStreakDays(0)
    }

    @Test
    fun addWaterOnce_displays250Ml() {
        addWaterButton.performClick()

        assertWaterAmount(250)
    }

    @Test
    fun addWaterMultipleTimes_accumulatesAmount() {
        addCups(10)

        assertWaterAmount(2500)
    }

    @Test
    fun finishDay_whenGoalReached_increasesStreakAndResetsWater() {
        addCups(6)

        endDayButton.performClick()

        assertStreakDays(1)
        assertWaterAmount(0)
    }

    @Test
    fun finishDay_whenGoalExceeded_increasesStreakAndResetsWater() {
        addCups(7)

        endDayButton.performClick()

        assertStreakDays(1)
        assertWaterAmount(0)
    }

    @Test
    fun finishDay_whenGoalNotReached_keepsZeroStreakAndResetsWater() {
        addCups(5)

        endDayButton.performClick()

        assertStreakDays(0)
        assertWaterAmount(0)
    }

    @Test
    fun finishDay_afterTwoSuccessfulDays_displaysStreakOfTwo() {
        addCups(6)
        endDayButton.performClick()

        addCups(6)
        endDayButton.performClick()

        assertStreakDays(2)
        assertWaterAmount(0)
    }

    @Test
    fun finishDay_afterUnsuccessfulDay_resetsExistingStreakAndWater() {
        addCups(6)
        endDayButton.performClick()
        assertStreakDays(1)

        addCups(5)
        endDayButton.performClick()

        assertStreakDays(0)
        assertWaterAmount(0)
    }

    private fun addCups(count: Int) {
        repeat(count) {
            addWaterButton.performClick()
        }
    }

    private fun assertWaterAmount(expectedMl: Int) {
        composeRule.onNodeWithText("$expectedMl мл")
            .assertIsDisplayed()
    }

    private fun assertStreakDays(expectedDays: Int) {
        composeRule.onNodeWithText("Текущая серия: $expectedDays дней")
            .assertIsDisplayed()
    }
}

