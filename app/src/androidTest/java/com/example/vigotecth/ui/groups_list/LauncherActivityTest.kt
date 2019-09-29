package com.example.vigotecth.ui.groups_list

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.vigotecth.R
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LauncherActivityTest {

    @Test
    fun agileVigoIsShown() {
        launch(LauncherActivity::class.java)

        onView(withId(R.id.btn_groups)).perform(click())

        Thread.sleep(5_000)

        onView(withText("Agile Vigo")).check(matches(isDisplayed()))
    }
}