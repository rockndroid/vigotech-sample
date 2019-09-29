package com.example.vigotecth.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.vigotecth.R

class GroupsTestRobot: ScreenRobot<GroupsTestRobot>() {

    fun goNextOnLauncher(): GroupsTestRobot {
        onView(withId(R.id.btn_groups)).perform(click())
        return this
    }

    fun verifyGroupIsShown(groupName: String) {
        onView(withText(groupName)).check(matches(isDisplayed()))
    }
}