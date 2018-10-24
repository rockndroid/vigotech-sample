package com.example.vigotecth.ui.groups_list

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
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
import com.jakewharton.espresso.OkHttp3IdlingResource
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@LargeTest
@RunWith(AndroidJUnit4::class)
class LauncherActivityTestWithIdling {

    @Inject lateinit var okHttpClient: OkHttpClient

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(LauncherActivity::class.java)

    private lateinit var okHttpIdling: OkHttp3IdlingResource

    @Before
    fun setUp() {
        (testApp().component() as TestAppComponent).inject(this)
        okHttpIdling = OkHttp3IdlingResource.create("okHttpIdling", okHttpClient)
        IdlingRegistry.getInstance().register(okHttpIdling)
    }

    @Test
    fun groupsAreShownTest() {
        // Look for the 'check groups', and do click
         onView(withId(R.id.btn_groups)).perform(click())

        // Check that a textView with 'Agile Vigo' is displayed
        onView(withText("Agile Vigo")).check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(okHttpIdling)
    }

    protected fun testApp(): VigoTechTestApp =
        InstrumentationRegistry.getInstrumentation()
            .targetContext.applicationContext as VigoTechTestApp

}
