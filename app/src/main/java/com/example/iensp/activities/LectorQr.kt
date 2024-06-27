package com.example.iensp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.iensp.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import java.time.LocalDate
import java.util.Date

class LectorQr : AppCompatActivity() {
    var buttonqr:Button?= null
    var textonombrealu:TextView?=null
    var VtextoDate:TextView?= null
    var VTextoFecha:TextView?=null
    var VTextDni:TextView?=null
    lateinit var resultadonombre:String
    val db =FirebaseFirestore.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lector_qr)

        VTextDni=findViewById(R.id.textViewDni)
        buttonqr= findViewById(R.id.buttonescaner)
        textonombrealu=findViewById(R.id.txtnombredealumno)
        VtextoDate=findViewById(R.id.TextDate)
        VTextoFecha=findViewById(R.id.TextHora)

        buttonqr?.setOnClickListener{ initScanner()}



    }
    private fun initScanner(){
        val integrator=IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        integrator.setPrompt("Escaneando Codigo de los Alumnos de las Peñas")
        integrator.setTorchEnabled(true)
        integrator.setBeepEnabled(true)
        integrator.initiateScan()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if(result!=null){
           if(result.contents == null){
               Toast.makeText(this,"Cancelado",Toast.LENGTH_SHORT).show()


           }else{
               Toast.makeText(this,"El valor escaneado es ${result.contents}",Toast.LENGTH_SHORT).show()
               VTextDni?.text=result.contents
               VtextoDate?.text= Date().toString()

               val docRef=db.collection("alumnos")
                   .whereEqualTo("DNI",VTextDni.toString())
                   .get()
                   .addOnSuccessListener { result ->
                       

                   }


           }
        }else{

        }
        super.onActivityResult(requestCode, resultCode, data)

    }
}