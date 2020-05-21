package com.example.module_61

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_student.*

class StudentActivity:AppCompatActivity(R.layout.activity_student) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntentData()

    }

    private fun handleIntentData() {
        intent.data?.path?.let {
            uriText.text = it
        }
    }
}