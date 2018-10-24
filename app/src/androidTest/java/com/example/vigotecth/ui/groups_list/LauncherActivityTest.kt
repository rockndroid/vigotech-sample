package com.example.vigotecth.ui.groups_list

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.vigotecth.R
import com.example.vigotecth.di.TestAppComponent
import com.example.vigotecth.di.VigoTechTestApp
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@LargeTest
@RunWith(AndroidJUnit4::class)
class LauncherActivityTest {

    @Inject lateinit var okHttpClient: OkHttpClient

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(LauncherActivity::class.java)

    @Before
    fun setUp() {
        (testApp().component() as TestAppComponent).inject(this)
    }

    @Test
    fun launcherActivityTest() {
        // Look for the 'check groups', and do click
         onView(withId(R.id.btn_groups)).perform(click())

        // Wait for the network call, TODO: Refactor
        Thread.sleep(10000)

        // Check that a textView with 'Agile Vigo' is displayed
        onView(withText("Agile Vigo")).check(matches(isDisplayed()))
    }

    protected fun testApp(): VigoTechTestApp =
        InstrumentationRegistry.getInstrumentation()
            .targetContext.applicationContext as VigoTechTestApp

}
