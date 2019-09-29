package com.example.vigotecth.ui.groups_list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.vigotecth.robots.GroupsTestRobot
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
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @Before
    fun startServer() {
        server = MockWebServer().apply {
            setDispatcher(MockDispatcher())
            start(8080)
        }
    }

    @Test
    fun agileVigoIsShown() {
        ActivityScenario.launch(LauncherActivity::class.java)

        withRobot(GroupsTestRobot::class.java)
            .goNextOnLauncher()
            .verifyGroupIsShown("Agile Vigo")
    }

    @Test
    fun aIndustrosa() {
        ActivityScenario.launch(LauncherActivity::class.java)

        withRobot(GroupsTestRobot::class.java)
            .goNextOnLauncher()
            .verifyGroupIsShown("A Industrosa")
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}
