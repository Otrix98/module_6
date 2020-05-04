package com.example.module_61

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editMail = findViewById<EditText>(R.id.editTextMail)
        val editPass = findViewById<EditText>(R.id.editTextPass)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val button = findViewById<Button>(R.id.button)






        editMail.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                isEnabled1 = s?.let { it.isNotEmpty() }?: false
                button.isEnabled = isEnabled()

            }

        })

        editPass.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               isEnabled2 = s?.let { it.isNotEmpty() }?: false
                button.isEnabled = isEnabled()
            }

        })



        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            isEnabled3 = isChecked
            button.isEnabled = isEnabled()
        }




        fun loginOperation() {
            val addProgressBar = ProgressBar (this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    gravity = Gravity.CENTER
                }
            }

//            progressBar.visibility = View.VISIBLE
            button.isEnabled = false
            conteiner.addView(addProgressBar)


            Handler().postDelayed({
                conteiner.removeView(addProgressBar)
//                progressBar.visibility = View.GONE
                checkBox.isChecked = false
                button.isEnabled = false
                Toast.makeText(this, R.string.hello_action, Toast.LENGTH_SHORT).show()
            }, 2000 )

        }

        button.setOnClickListener {


            editMail.setText("")
            editPass.setText("")
            loginOperation()
        }

        }


    }
var isEnabled1 = false
var isEnabled2 = false
var isEnabled3 = false

fun isEnabled (): Boolean {
        return isEnabled1  && isEnabled2 && isEnabled3
    }