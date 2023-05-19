package anzila.binar.challengeenam.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import anzila.binar.challengeenam.adapter.FilmAdapter
import anzila.binar.challengeenam.databinding.ActivityHomeBinding
import anzila.binar.challengeenam.viewmodel.FilmViewModel
import dagger.hilt.android.AndroidEntryPoint

@Suppress("RedundantSamConstructor", "ReplaceGetOrSet", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate"
)
@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding
    lateinit var adapterfilm : FilmAdapter
    lateinit var sharedPref: SharedPreferences
    lateinit var viewModelFilm : FilmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = getSharedPreferences("dataUser", Context.MODE_PRIVATE)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getName = sharedPref.getString("nama", "")
        binding.txtWel.text = "Halo, $getName"

        viewModelFilm = ViewModelProvider(this).get(FilmViewModel::class.java)
        adapterfilm = FilmAdapter(emptyList())
        val layoutMan = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvFilm.layoutManager = layoutMan
        binding.rvFilm.adapter = adapterfilm

        viewModelFilm.getliveDataFilm().observe(this, Observer {
            if (it != null) {
                adapterfilm.setDataFilm(it)
                adapterfilm.notifyDataSetChanged()
            }
        })
        viewModelFilm.callApiFilm()

        binding.rvFilm.apply{
            layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.VERTICAL, false)
            adapter = adapterfilm
            adapterfilm.onClick={ film ->
                val inten = Intent(context, DetailActivity::class.java)
                inten.putExtra("detailfilm", film)
                startActivity(inten)
            }
        }

        binding.klikProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        binding.klikFavorite.setOnClickListener {
            startActivity(Intent(this, FavoriteActivity::class.java))
        }
    }
}