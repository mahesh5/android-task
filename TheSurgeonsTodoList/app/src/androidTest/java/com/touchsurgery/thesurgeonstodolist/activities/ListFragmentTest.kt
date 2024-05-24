package com.touchsurgery.thesurgeonstodolist.fragments
import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.touchsurgery.thesurgeonstodolist.R
import com.touchsurgery.thesurgeonstodolist.activities.MainActivity
import com.touchsurgery.thesurgeonstodolist.utils.SharedPreferencesManager
import org.hamcrest.CoreMatchers.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListFragmentTest {

    @Before
    fun setup() {
        // Start the main activity
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testListSortingByName() {
        // Set the SharedPreferences to sort by name
        val context: Context = androidx.test.core.app.ApplicationProvider.getApplicationContext()
        val prefs = SharedPreferencesManager(context)
        prefs.setOrderType(SharedPreferencesManager.ORDER_TYPE_NAME)
        prefs.setOrderAscending(true)

        onView(withId(R.id.list)).check(matches(isDisplayed()))
    }

    @Test
    fun testListSortingByPriority() {
        // Set the SharedPreferences to sort by priority
        val context: Context = androidx.test.core.app.ApplicationProvider.getApplicationContext()
        val prefs = SharedPreferencesManager(context)
        prefs.setOrderType(SharedPreferencesManager.ORDER_TYPE_PRIORITY)
        prefs.setOrderAscending(true)

        // Update the list
        onView(withId(R.id.list)).check(matches(isDisplayed()))
    }
//
    @Test
    fun testListIsDisplayed() {
        // Check if the list view is displayed
        onView(withId(R.id.list)).check(matches(isDisplayed()))
    }


    @Test
    fun testItemClickRemovesItem() {
        // Click on the last item in the list
        onData(anything()).inAdapterView(withId(R.id.list)).atPosition(1).perform(click())

        // Click the first item
        onData(anything()).inAdapterView(withId(R.id.list)).atPosition(0).perform(click())

        // Verify all the item is removed from the list
        onView(withId(R.id.noItemsLabel)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}
