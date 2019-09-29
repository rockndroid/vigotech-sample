package com.example.vigotecth.robots

abstract class ScreenRobot<T : ScreenRobot<T>> {

    companion object {
        fun <T  : ScreenRobot<*>> withRobot(robotClass: Class<T>): T {
            return robotClass.newInstance()
        }
    }
}