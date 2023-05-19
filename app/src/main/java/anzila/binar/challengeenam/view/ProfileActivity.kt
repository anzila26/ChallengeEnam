package anzila.binar.challengeenam.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import anzila.binar.challengeenam.R
import anzila.binar.challengeenam.databinding.ActivityProfileBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@Suppress("unused", "unused", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate"
)
@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {
    lateinit var binding : ActivityProfileBinding
    lateinit var sharedPref : SharedPreferences
    lateinit var mGoogleSignInClient: GoogleSignInClient
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("dataUser", Context.MODE_PRIVATE)
        val getUsname = sharedPref.getString("uname", "")
        val getName = sharedPref.getString("nama", "")
        binding.txtUname.text = "$getUsname"
        binding.txtName.text = "$getName"
        binding.btnUpdate.setOnClickListener {
            val uName = binding.etUnameProf.text.toString()
            val nPanjang = binding.etNameProf.text.toString()
            val tglLahir = binding.etDate.text.toString()
            val address = binding.etAddress.text.toString()
            val update = sharedPref.edit()
            update.putString("username", uName)
            update.putString("namapanjang", nPanjang)
            update.putString("ttl", tglLahir)
            update.putString("alamat", address)
            update.apply()
            val getUname = sharedPref.getString("username", "")
            val getLname = sharedPref.getString("namapanjang", "")
            val getTtl = sharedPref.getString("ttl", "")
            val getAdd = sharedPref.getString("alamat", "")
            binding.txtUname.text = getUname
            binding.txtName.text = getLname
            binding.txtTtl.text = getTtl
            binding.txtAlamat.text = getAdd
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.btnLogout.setOnClickListener {
            mGoogleSignInClient.signOut().addOnCompleteListener {
                val intent = Intent(this, LoginActivity::class.java)
                Toast.makeText(this, "Logging Out", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }

            sharedPref = getSharedPreferences("dataUser", Context.MODE_PRIVATE)
            val delete = sharedPref.edit()
            delete?.clear()
            delete?.apply()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}