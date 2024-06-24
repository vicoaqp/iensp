package com.example.iensp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.iensp.R

class MainActivity : AppCompatActivity() {

    var imageViewToRegister: ImageView?=null
    var editTextEmail: EditText?=null
    var editTextPassword: EditText?=null
    var buttonLogin: Button?=null
    var buttongoqr: Button?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        imageViewToRegister= findViewById(R.id.imageview_go_to_register)
        editTextEmail=findViewById(R.id.edittext_email)
        editTextPassword=findViewById(R.id.edittext_Password)
        buttonLogin=findViewById(R.id.btn_login)
        buttongoqr=findViewById(R.id.buttongoqr)


        imageViewToRegister?.setOnClickListener{goToRegister() }
        buttongoqr?.setOnClickListener{goToScanner()}

    }
    private fun login(){
        val email = editTextEmail?.text.toString()
        val password = editTextPassword?.text.toString()

    }
    private fun goToScanner(){
        val d = Intent(this,LectorQr::class.java)
        startActivity(d)
    }
    private fun goToRegister(){
        val i = Intent(this,RegisterActivity::class.java)
        startActivity(i)
    }
}