package com.example.vigotecth.ui.groups_list

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.vigotecth.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LauncherActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(LauncherActivity::class.java)

    @Test
    fun launcherActivityTest() {
        // Look for the 'check groups', and do click
         onView(withId(R.id.btn_groups)).perform(click())

        // Wait for the network call, TODO: Refactor
        Thread.sleep(10000)

        // Check that a textView with 'Agile Vigo' is displayed
        onView(withText("Agile Vigo")).check(matches(isDisplayed()))
    }
}
