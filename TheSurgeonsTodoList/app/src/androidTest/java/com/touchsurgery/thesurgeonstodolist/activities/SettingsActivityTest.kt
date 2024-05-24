package com.touchsurgery.thesurgeonstodolist.activities
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.touchsurgery.thesurgeonstodolist.R
import org.junit.Rule
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

import org.junit.Test

class SettingsActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(SettingsActivity::class.java)

    @Test
    fun testRadioButton() {
        onView(withId(R.id.radioSortPriority)).perform(click())

        // Verify that the radio button for sorting by priority is selected
        onView(withId(R.id.radioSortPriority)).check(matches(isChecked()))

        // Verify that the radio button for sorting by priority is selected
        onView(withId(R.id.radioSortName)).perform(click())

        // Verify that the radio button for sorting by priority is selected
        onView(withId(R.id.radioSortName)).check(matches(isChecked()))
    }

    @Test
    fun testSwitchButtonToggle() {
        // Click on the switch button to toggle descending order
        onView(withId(R.id.switchAscending)).perform(click())

        // Check if the switch button for ascending order is checked
        onView(withId(R.id.switchAscending)).check(matches(isChecked()))
    }
}
