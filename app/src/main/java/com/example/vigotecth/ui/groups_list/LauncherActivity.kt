package com.example.vigotecth.ui.groups_list

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.vigotecth.R
import androidx.appcompat.app.AppCompatActivity

class LauncherActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        findViewById<Button>(R.id.btn_groups).setOnClickListener {
            startActivity(Intent(this, GroupsListActivity::class.java)).also { finish() }
        }
    }
}