package com.example.vigotecth.ui.groups_list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import com.example.vigotecth.R
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.example.vigotecth.utils.EspressoIdlingResource

class LauncherActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val groupsButton = findViewById<Button>(R.id.btn_groups).apply {
            alpha = 0f
            translationY = 25f

            setOnClickListener {
                startActivity(Intent(
                    this@LauncherActivity,
                    GroupsListActivity::class.java)).also { finish() }
            }
        }

        EspressoIdlingResource.increment()

        ViewCompat.animate(groupsButton)
            .alpha(1f)
            .translationY(0f)
            .setStartDelay(1000)
            .setInterpolator(DecelerateInterpolator(3f))
            .setDuration(3000)
            .withEndAction { EspressoIdlingResource.decrement() }
            .start()
    }
}