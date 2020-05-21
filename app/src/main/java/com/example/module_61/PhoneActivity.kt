package com.example.module_61

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_phone.*

class PhoneActivity: AppCompatActivity(R.layout.activity_phone) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setPhoneFromIntent()
    }

    private fun setPhoneFromIntent(){
        val phones = intent.getStringArrayExtra(Intent.EXTRA_PHONE_NUMBER)

        phoneTextView.text = phones?.joinToString() ?: "Phone is not set"
    }
}