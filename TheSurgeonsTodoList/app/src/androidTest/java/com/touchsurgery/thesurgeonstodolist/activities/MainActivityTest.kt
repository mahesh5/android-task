package com.touchsurgery.thesurgeonstodolist.activities
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.touchsurgery.thesurgeonstodolist.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get : Rule
    var mActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        //initial setup code
    }

    @Test
    fun clickForAddData() {
        onView(withId(R.id.fab)).perform(click())
    }

    @Test
    fun clickToolBar() {
        onView(withId(R.id.toolbar)).perform(click())
    }

    @After
    fun tearDown() {
        //clean up code
    }
}
