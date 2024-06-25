package com.example.iensp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import com.example.iensp.Fragmentos.FragmentEvento
import com.example.iensp.Fragmentos.FragmentInicio
import com.example.iensp.databinding.ActivityMainBinding
import com.example.iensp.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        verFragmentInicio()

        binding.BottomNV.setOnItemSelectedListener{item ->
            when(item.itemId){
                R.id.Item_Inicio->{
                    verFragmentInicio()
                    true
                }
                R.id.item_Eventos->{
                    verFragmentEvento()
                    true
                }
                R.id.item_Contacto->{
                    true
                }
                R.id.item_Cuenta->{
                    true
                }
                R.id.item_Anuncios->{
                    true
                }
                else->{
                    false
                }
            }

        }

    }
    private fun verFragmentInicio(){

        val fragment = FragmentInicio()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.FragmentL1.id,fragment,"FragmentInicio")
        fragmentTransaction.commit()
    }
    private fun verFragmentEvento(){

        val fragment = FragmentEvento()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.FragmentL1.id,fragment,"FragmentEvento")
        fragmentTransaction.commit()
    }
}