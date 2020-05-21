package com.example.module_61

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.invoke
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity:AppCompatActivity(R.layout.activity_second) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val louncher = prepareCall(ActivityResultContracts.Dial()){
            it?: Toast.makeText(this, "Вызов отменен!", Toast.LENGTH_SHORT).show()
            resultPhone.text = "Вызов совершен"
        }



        callButton.setOnClickListener {
            val phone = phoneEdit.text.toString()

            val isPhoneValid = Patterns.PHONE.matcher(phone).matches()

            if (!isPhoneValid) {
                Toast.makeText(this, "Введите корректный телефон!", Toast.LENGTH_SHORT).show()
            }else {
                val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$phone")
                    putExtra(Intent.EXTRA_PHONE_NUMBER, arrayOf(phone))
                    louncher(phone)
                }
                if (phoneIntent.resolveActivity(packageManager) != null) {
                    startActivity(phoneIntent)
                }else {
                    Toast.makeText(this, "No component to handle intent!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



}