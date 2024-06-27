package com.example.iensp

<<<<<<< HEAD
import android.content.Intent
=======
>>>>>>> 1133e46a88e0c992622e22ee7e888cb635e24087
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import com.example.iensp.Fragmentos.FragmentEvento
import com.example.iensp.Fragmentos.FragmentInicio
<<<<<<< HEAD
import com.example.iensp.activities.LectorQr
=======
>>>>>>> 1133e46a88e0c992622e22ee7e888cb635e24087
import com.example.iensp.databinding.ActivityMainBinding
import com.example.iensp.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        verFragmentInicio()
<<<<<<< HEAD
        binding.FAB.setOnClickListener{goToScanner()}
=======
>>>>>>> 1133e46a88e0c992622e22ee7e888cb635e24087

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
<<<<<<< HEAD
                R.id.item_Escaneo->{
                    goToScanner()
=======
                R.id.item_Anuncios->{
>>>>>>> 1133e46a88e0c992622e22ee7e888cb635e24087
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
<<<<<<< HEAD

    private fun goToScanner(){
        val d = Intent(this, LectorQr::class.java)
        startActivity(d)
    }
=======
>>>>>>> 1133e46a88e0c992622e22ee7e888cb635e24087
    private fun verFragmentEvento(){

        val fragment = FragmentEvento()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.FragmentL1.id,fragment,"FragmentEvento")
        fragmentTransaction.commit()
    }
}