package com.bakten.mondayhero_case

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signin.*

class SignInPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
    }

    fun Login(view: View) {

        if(isAvailableInput()){
            var intent = Intent(this,  PlayListPage::class.java )
            startActivity(intent)
        }else{
            Toast.makeText(this, "Invalid Input! Try Again!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isAvailableInput() : Boolean{
        return !email_edittext.text.isNullOrEmpty() && !password_edittext.text.isNullOrEmpty()
    }
}
