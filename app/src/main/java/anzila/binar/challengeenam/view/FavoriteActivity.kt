package anzila.binar.challengeenam.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import anzila.binar.challengeenam.adapter.FavoriteAdapter
import anzila.binar.challengeenam.databinding.ActivityFavoriteBinding
import anzila.binar.challengeenam.model.ResponseFilmItem
import anzila.binar.challengeenam.room.FavoriteData
import anzila.binar.challengeenam.room.FavoriteDatabase
import anzila.binar.challengeenam.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@Suppress("ReplaceGetOrSet", "RedundantSamConstructor")
@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFavoriteBinding
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var favoriteAdapter: FavoriteAdapter
    private var favoriteDatabase: FavoriteDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        favoriteDatabase = FavoriteDatabase.getInstance(this)

        favoriteViewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)
        favoriteAdapter = FavoriteAdapter(emptyList())

        binding.rvFavorite.apply {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            adapter = favoriteAdapter
            favoriteAdapter.onClick={ favoriteData ->
                val inten = Intent(context, DetailActivity::class.java)
                val film = ResponseFilmItem(
                    null,
                    favoriteData.id,
                    favoriteData.image,
                    favoriteData.movieName,
                    favoriteData.rate,
                    favoriteData.release,
                    favoriteData.synopsis
                )
                inten.putExtra("detailfilm", film)
                startActivity(inten)
            }
        }

        favoriteViewModel.allFavorite.observe(this, Observer {
            favoriteAdapter.setNewData(it)
        })

        favoriteViewModel.getAllFavorite()
    }
}