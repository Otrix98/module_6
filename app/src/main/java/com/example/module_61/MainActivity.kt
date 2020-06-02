package com.example.module_61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.core.view.marginTop
import com.afollestad.vvalidator.form
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity(R.layout.activity_main), ItemSelectListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showLoginFragment()




    }

    private fun showLoginFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, LoginFragment())
            .commit()
    }

   fun showMainFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()

    }

    override fun onItemSelected(text: String) {

    }

    override fun onBackPressed() {
        val mainFragment = supportFragmentManager.findFragmentById(R.id.container)
        val  childFragment = mainFragment?.childFragmentManager
            ?.findFragmentById(R.id.container_main)
        (childFragment as? ListFragment)?.let {
            finish()
        }
        mainFragment?.childFragmentManager?.beginTransaction()
            ?.replace(R.id.container_main, ListFragment())
            ?.commit()
    }
}