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
import java.io.Serializable

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
      //  showDataFilm()

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
     //       adapter = adapterfilm
    //        adapterfilm.onClick={
     //           var det = it.movieName
     //           val detail = Intent(context, DetailActivity::class.java)
     //           detail.putExtra("detailfilm", det)
     //           startActivity(detail)
      //      }
       // }
    //    adapterfilm = FilmAdapter() {
     //       val det = it.movieName
     //       val detail = Intent(applicationContext, DetailActivity::class.java)
     //       detail.putExtra("detailfilm", det)
     //       startActivity(detail)
    //    }
      //  binding.rvFilm.adapter = adapterfilm


        binding.klikProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

 //   fun showDataFilm() {
   //     val viewModelFilm = ViewModelProvider(this).get(FilmViewModel::class.java)
   //     viewModelFilm.getliveDataFilm().observe(this, Observer {
    //        if (it != null){
      //          adapterfilm.setDataFilm(it)
     //           adapterfilm.notifyDataSetChanged()
     //       }
     //   })
    //    viewModelFilm.callApiFilm()
   // }
}