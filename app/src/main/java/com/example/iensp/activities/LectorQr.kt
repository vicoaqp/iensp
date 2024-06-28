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
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

class LectorQr : AppCompatActivity() {
    var buttonqr:Button?= null
    var buttongrabar:Button?= null
    var textonombrealu:TextView?=null
    var VtextoDate:TextView?= null
    var VTextoHora:TextView?=null
    var VTextDni:TextView?=null
    var VTextGrado:TextView?= null

    lateinit var resultadonombre:String
    val db =FirebaseFirestore.getInstance()

    var codigoaref:String?=""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lector_qr)


        VTextDni=findViewById(R.id.textViewDni)
        buttonqr= findViewById(R.id.buttonescaner)
        buttongrabar=findViewById(R.id.buttongrabard)
        textonombrealu=findViewById(R.id.txtnombredealumno)
        VtextoDate=findViewById(R.id.TextDate)
        VTextoHora=findViewById(R.id.TextHora)
        VTextGrado=findViewById(R.id.TextGradoseccion)

        buttongrabar?.setOnClickListener{gograbar()}
        buttonqr?.setOnClickListener{ initScanner()}



    }
    private fun gograbar(){

            val userMap=   hashMapOf(
            "dni" to VTextDni?.text,
            "nombres" to textonombrealu?.text,
                "grado" to VTextGrado?.text,
                "fecha" to VtextoDate?.text,
                "hora" to VTextoHora?.text
        )
        val docGrab=db.collection("asistencia")
            .add(userMap)
            .addOnSuccessListener {Docrefere ->
                VTextDni?.text=""
                textonombrealu?.text=""
                VTextGrado?.text=""
                VtextoDate?.text=""
                VTextoHora?.text=""
            }


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
               //Toast.makeText(this,"El valor escaneado es ${result.contents}",Toast.LENGTH_SHORT).show()
               VTextDni?.text=result.contents

               codigoaref= VTextDni.toString()

               Toast.makeText(this,codigoaref.toString(),Toast.LENGTH_SHORT).show()


               val formatter = SimpleDateFormat("MM-dd-yyyy")
               VtextoDate?.text= formatter.format(Date())

               val formatterh = SimpleDateFormat("hh:mm:ss a")
               VTextoHora?.text = formatterh.format(Date())


               val docRef=db.collection("alumnos")
                   .whereEqualTo("DNI",result.contents)
                   .get()
                   .addOnSuccessListener {result ->
                       for (document in result) {
                            textonombrealu?.text=document.data.get("namelast").toString()
                           VTextGrado?.text=document.data.get("gradoseccion").toString()
                       }
                   }
           }
        }else{

        }
        super.onActivityResult(requestCode, resultCode, data)

    }
}