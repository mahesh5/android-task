package com.touchsurgery.thesurgeonstodolist.steps

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.touchsurgery.thesurgeonstodolist.R
import com.touchsurgery.thesurgeonstodolist.activities.ListFragment
import com.touchsurgery.thesurgeonstodolist.activities.MainActivity
import com.touchsurgery.thesurgeonstodolist.utils.Item
import com.touchsurgery.thesurgeonstodolist.utils.SharedPreferencesManager
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.hamcrest.CoreMatchers.anything


class ListFragmentSteps {
    private lateinit var context: Context

    @Given("I have launched the MainActivity")
    fun launchMainActivity() {
        ActivityScenario.launch(MainActivity::class.java).onActivity { activity ->
            context = activity
        }
    }

    @When("I view the list")
    fun viewList() {
        onView(withId(R.id.list)).check(matches(isDisplayed()))
    }

    @Then("I should see the list displayed")
    fun checkListIsDisplayed() {
        onView(withId(R.id.list)).check(matches(isDisplayed()))
    }

    @Given("I have set the sort order to name ascending")
    fun setSortOrderToNameAscending() {
        val prefs = SharedPreferencesManager(context)
        prefs.setOrderType(SharedPreferencesManager.ORDER_TYPE_NAME)
        prefs.setOrderAscending(true)
    }

    @When("I update the list")
    fun updateList() {

    }

}