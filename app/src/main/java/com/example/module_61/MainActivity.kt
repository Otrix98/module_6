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

class MainActivity : AppCompatActivity() {

    private var formValid = FormState(false, "Ошибка!")

    private val tag = "Main Activity"

    fun updateErrorText() {
        if (formValid.valid) {
            errorText.text= " "
            errorText.visibility = View.GONE
        } else if(!formValid.valid && checkBox.isChecked ){
            errorText.visibility = View.VISIBLE
            errorText.text= formValid.message
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        if (savedInstanceState != null) {
            formValid =
                savedInstanceState.getParcelable<FormState>(KEY_VALID) ?: error("Unexpected state")

        }

//        val addError = TextView(this).apply {
//            text = formValid.message
//            layoutParams = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//            ).apply {
//                gravity = Gravity.CENTER
//            }
//        }


        Log.v(tag, "OnCreatewas called")
        Log.d(tag, "OnCreatewas called")
        Log.i(tag, "OnCreatewas called")
        Log.e(tag, "OnCreatewas called")
        Log.println(Log.ASSERT, tag, "OnCreatewas called")

        buttonAnr.setOnClickListener {
            Thread.sleep(10000)
        }


        val editMail = findViewById<EditText>(R.id.editTextMail)
        val editPass = findViewById<EditText>(R.id.editTextPass)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val button = findViewById<Button>(R.id.button)






        editMail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                isEnabled1 = s?.let { it.isNotEmpty() } ?: false
                button.isEnabled = isEnabled()

            }

        })

        editPass.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                isEnabled2 = s?.let { it.isNotEmpty() } ?: false
                button.isEnabled = isEnabled()

            }

        })



        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            isEnabled3 = isChecked
            button.isEnabled = isEnabled()
        }




        fun loginOperation() {


            val addProgressBar = ProgressBar(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    gravity = Gravity.CENTER
                }
            }

            button.isEnabled = false
            conteiner.addView(addProgressBar)


            Handler().postDelayed({
                conteiner.removeView(addProgressBar)
                checkBox.isChecked = false
                button.isEnabled = false
                Toast.makeText(this, R.string.hello_action, Toast.LENGTH_SHORT).show()
            }, 2000)
//            conteiner.removeView(addError)
//            errorText.text= " "
//            errorText.visibility = View.GONE
            formValid.valid = true
            updateErrorText()
            finish()

        }



        button.setOnClickListener {
            val isEmailValid:Boolean = Patterns.EMAIL_ADDRESS.matcher(editMail.text.toString()).matches()
            if(isEmailValid && checkBox.isChecked){
            formValid.valid = true }


            val secondActivityIntent = Intent(
                this,
                SecondActivity::class.java
            )
            startActivity(secondActivityIntent)




        if(formValid.valid){
            editMail.setText("")
            editPass.setText("")
            loginOperation()
        }else {
            updateErrorText()
//            errorText.visibility = View.VISIBLE
//            errorText.text= formValid.message
//            conteiner.addView(addError) }
    }}


        }

    override fun onResume() {
        super.onResume()
        Log.v(tag, "OnResumeewas called")
        updateErrorText()
    }

    override fun onPause() {
        super.onPause()
        Log.v(tag, "OnPausewas called")
    }

    override fun onStop() {
        super.onStop()
        Log.v(tag, "OnStopwas called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(tag, "OnDestroywas called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_VALID, formValid)
    }

    companion object {
        private const val KEY_VALID = "valid"
    }




    var isEnabled1 = false
    var isEnabled2 = false
    var isEnabled3 = false


    fun isEnabled(): Boolean {
        return isEnabled1 && isEnabled2 && isEnabled3
    }
}