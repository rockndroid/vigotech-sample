package com.example.vigotecth.ui.groups_list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.vigotecth.R
import com.example.vigotecth.server.MockDispatcher
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LauncherActivityTest {

    @Test
    fun groupsAreShown() {
        MockWebServer().apply {
            setDispatcher(MockDispatcher())
            start(8080)
        }

        ActivityScenario.launch(LauncherActivity::class.java)

        // Look for the 'check groups', and do click
         onView(withId(R.id.btn_groups)).perform(click())

        // Wait for the network call, TODO: Refactor
        Thread.sleep(10000)

        // Check that a textView with 'Agile Vigo' is displayed
        onView(withText("Agile Vigo")).check(matches(isDisplayed()))
    }
}
