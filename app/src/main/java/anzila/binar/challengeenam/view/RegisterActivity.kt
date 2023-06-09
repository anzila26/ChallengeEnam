package anzila.binar.challengeenam.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import anzila.binar.challengeenam.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@Suppress("MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate"
)
@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    lateinit var binding : ActivityRegisterBinding
    lateinit var sharedPref: SharedPreferences
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnReg.setOnClickListener {
            val nama = binding.etNameReg.text.toString()
            val uname = binding.etUnameReg.text.toString()
            val pass = binding.etPassReg.text.toString()
            val rePass = binding.etRepass.text.toString()
            val rPref = sharedPref.edit()
            rPref.putString("nama", nama)
            rPref.putString("uname", uname)
            rPref.apply()

            if (uname.isNotEmpty() && pass.isNotEmpty() && rePass.isNotEmpty()) {
                if (pass == rePass) {
                    firebaseAuth.createUserWithEmailAndPassword(uname, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }

        sharedPref = getSharedPreferences("dataUser", Context.MODE_PRIVATE)
    }
}