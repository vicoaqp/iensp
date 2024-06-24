package com.example.iensp.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.iensp.R

class RegisterActivity : AppCompatActivity() {
   var imageViewGoToLogin:ImageView?= null
    var editTextName: EditText?=null
    var editTextLastName: EditText?=null
    var editTextPhone: EditText?=null
    var editTextPassword: EditText?=null
    var editTextConfirmaPassword: EditText?=null
    var editTextEmail:EditText?= null
    var buttonRegister:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)


        imageViewGoToLogin=findViewById(R.id.imageview_go_to_register)

       editTextName=findViewById(R.id.edittext_name)
        editTextLastName=findViewById(R.id.edittext_lastname)
        editTextEmail=findViewById(R.id.edittext_email)
        editTextPhone=findViewById(R.id.editTextPhone)
        editTextPassword=findViewById(R.id.edittext_password)
        editTextConfirmaPassword=findViewById(R.id.edittext_confirm_password)
        buttonRegister=findViewById(R.id.btn_register)


        imageViewGoToLogin?.setOnClickListener{goToLogin()}
        buttonRegister?.setOnClickListener{register()}
    }

    private fun register(){
       val name=editTextName?.text.toString()
        val lastname=editTextLastName?.text.toString()
        val phone=editTextPhone?.text.toString()
        val email=editTextEmail?.text.toString()
        val password=editTextPassword?.text.toString()
        val confirmepassword=editTextConfirmaPassword?.text.toString()


        if (isValidForm(name = name, phone = phone, lastname = lastname, email = email, password = password, confirmPassword = confirmepassword)) {
            /*
            val user = User(
                name = name,
                lastname = lastname,
                email = email,
                phone = phone,
                password = password
            )

            usersProvider.register(user)?.enqueue(object: Callback<ResponseHttp> {
                override fun onResponse(call: Call<ResponseHttp>, response: Response<ResponseHttp>) {

                    if (response.body()?.isSuccess == true) {
                        saveUserInSession(response.body()?.data.toString())
                        goToClientHome()
                    }

                    Toast.makeText(this@RegisterActivity, response.body()?.message, Toast.LENGTH_LONG).show()

                    Log.d(TAG, "Response: ${response}" )
                    Log.d(TAG, "Body: ${response.body()}" )
                }

                override fun onFailure(p0: Call<ResponseHttp>, t: Throwable) {
                    Log.d(TAG, "Se produjo un error ${t.message}")
                    Toast.makeText(this@RegisterActivity, "Se produjo un error ${t.message}", Toast.LENGTH_LONG).show()
                }

            })
                */
        }

    }
    private fun goToLogin(){
        val d = Intent(this,MainActivity::class.java)
        startActivity(d)
    }
    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun isValidForm(
        name: String,
        lastname: String,
        email: String,
        phone: String,
        password: String,
        confirmPassword: String
    ): Boolean {

        if (name.isBlank()) {
            Toast.makeText(this, "Debes ingresar el nombre", Toast.LENGTH_SHORT).show()
            return false
        }

        if (lastname.isBlank()) {
            Toast.makeText(this, "Debes ingresar el apellido", Toast.LENGTH_SHORT).show()
            return false
        }

        if (phone.isBlank()) {
            Toast.makeText(this, "Debes ingresar el telefono", Toast.LENGTH_SHORT).show()
            return false
        }

        if (email.isBlank()) {
            Toast.makeText(this, "Debes ingresar el email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.isBlank()) {
            Toast.makeText(this, "Debes ingresar el contraseña", Toast.LENGTH_SHORT).show()
            return false
        }

        if (confirmPassword.isBlank()) {
            Toast.makeText(this, "Debes ingresar el la confirmacion de contraseña", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!email.isEmailValid()) {
            Toast.makeText(this, "El email no es valido", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

}