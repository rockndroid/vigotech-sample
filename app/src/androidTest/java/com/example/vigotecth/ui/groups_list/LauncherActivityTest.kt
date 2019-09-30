package com.example.vigotecth.ui.groups_list

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.vigotecth.R
import com.example.vigotecth.robots.GroupsTestRobot
import com.example.vigotecth.robots.ScreenRobot
import com.example.vigotecth.robots.ScreenRobot.Companion.withRobot
import com.example.vigotecth.server.MockDispatcher
import com.example.vigotecth.utils.EspressoIdlingResource
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LauncherActivityTest {

    lateinit var server: MockWebServer

    @Before
    fun startServer() {
        server = MockWebServer().apply {
            setDispatcher(MockDispatcher())
            start(8080)
        }
    }

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun agileVigoIsShown() {
        launch(LauncherActivity::class.java)

        withRobot(GroupsTestRobot::class.java)
            .goNextOnLauncher()
            .verifyGroupIsShown("Agile Vigo")
    }

    @Test
    fun aIndustrosaIsShown() {
        launch(LauncherActivity::class.java)

        withRobot(GroupsTestRobot::class.java)
            .goNextOnLauncher()
            .verifyGroupIsShown("A Industrosa")
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}