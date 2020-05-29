package com.example.module_61

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment: Fragment(R.layout.fragment_login) {

//    private val itemSelectListener: ItemSelectListener?
//        get() = activity?.let { it as? ItemSelectListener }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        if (savedInstanceState != null) {
            formValid =
                savedInstanceState.getParcelable<FormState>(KEY_VALID) ?: error("Unexpected state")

        }


        Log.v(tag1, "OnCreatewas called")
        Log.d(tag1, "OnCreatewas called")
        Log.i(tag1, "OnCreatewas called")
        Log.e(tag1, "OnCreatewas called")
        Log.println(Log.ASSERT, tag1, "OnCreatewas called")

        buttonAnr.setOnClickListener {
            Thread.sleep(10000)
        }





        editTextMail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                isEnabled1 = s?.let { it.isNotEmpty() } ?: false
                button.isEnabled = isEnabled()

            }

        })

        editTextPass.addTextChangedListener(object : TextWatcher {
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


            val addProgressBar = ProgressBar(activity).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    gravity = Gravity.CENTER
                }
            }

            button.isEnabled = false
            conteiner.addView(addProgressBar)


//            Handler().postDelayed({
//                conteiner.removeView(addProgressBar)
//                checkBox.isChecked = false
//                button.isEnabled = false
//                Toast.makeText(activity, R.string.hello_action, Toast.LENGTH_SHORT).show()
//            }, 2000)

            formValid.valid = true
            updateErrorText()


        }



        button.setOnClickListener {
            val isEmailValid:Boolean = Patterns.EMAIL_ADDRESS.matcher(editTextMail.text.toString()).matches()
            if(isEmailValid && checkBox.isChecked){
                formValid.valid = true

            (activity as MainActivity).showMainFragment()
        }

//            val secondActivityIntent = Intent(
//                activity,
//                SecondActivity::class.java
//            )
//            startActivity(secondActivityIntent)




            if(formValid.valid){
                editTextMail.setText("")
                editTextPass.setText("")
                loginOperation()
            }else {
                updateErrorText()
            }
        }


    }

    companion object {
        private const val KEY_VALID = "valid"

//        private const val KEY_LOGIN = "key_login"

//        fun newInstance(text: String): LoginFragment {
//            val fragment = LoginFragment().whithArguments()
//            return LoginFragment().whithArguments {
//                putString(KEY_LOGIN, text)
//            }
//        }
    }





    private var formValid = FormState(false, "Ошибка!")

    private val tag1 = "Main Activity"

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



    }

    override fun onResume() {
        super.onResume()
        Log.v(tag1, "OnResumeewas called")
        updateErrorText()
    }

    override fun onPause() {
        super.onPause()
        Log.v(tag1, "OnPausewas called")
    }

    override fun onStop() {
        super.onStop()
        Log.v(tag1, "OnStopwas called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(tag1, "OnDestroywas called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_VALID, formValid)
    }






    var isEnabled1 = false
    var isEnabled2 = false
    var isEnabled3 = false


    fun isEnabled(): Boolean {
        return isEnabled1 && isEnabled2 && isEnabled3
    }
}
