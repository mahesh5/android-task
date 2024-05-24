package com.touchsurgery.thesurgeonstodolist.activities

import android.view.View
import android.widget.SeekBar
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.touchsurgery.thesurgeonstodolist.R
import org.junit.Rule

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.junit.Test

class AddItemFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testAddItem() {
        // Click on the FAB to open the AddItemFragment
        onView(withId(R.id.fab)).perform(click())

        // Verify that the AddItemFragment is displayed
        onView(withId(R.id.todoText)).check(matches(isDisplayed()))
//
//        // Set text in the todoText EditText
        onView(withId(R.id.todoText)).perform(typeText("New Item"), closeSoftKeyboard())

       // Perform action to set progress on the SeekBar to 5
        onView(withId(R.id.seekBar)).perform(setSeekBarProgress(5))

        // Verify the SeekBar progress
        onView(withId(R.id.seekBar)).check(matches(withProgress(5)))

        // Verify the text displayed in the TextView
        onView(withId(R.id.priorityValue)).check(matches(withText("5")))

        // Click the submit button
        onView(withId(R.id.submitTodo)).perform(click())
    }

    // Custom action to set SeekBar progress
    private fun setSeekBarProgress(progress: Int) = object : ViewAction {
        override fun getConstraints() = isAssignableFrom(SeekBar::class.java)

        override fun getDescription() = "Set SeekBar progress to $progress"

        override fun perform(uiController: androidx.test.espresso.UiController, view: android.view.View) {
            val seekBar = view as SeekBar
            seekBar.progress = progress
        }
    }

    // Custom matcher for SeekBar progress
    private fun withProgress(expectedProgress: Int) = object : TypeSafeMatcher<View>() {
        override fun describeTo(description: Description?) {
            description?.appendText("SeekBar progress is: $expectedProgress")
        }

        override fun matchesSafely(view: View?): Boolean {
            if (view !is SeekBar) {
                return false
            }
            return view.progress == expectedProgress
        }
    }
}
