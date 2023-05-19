package anzila.binar.challengeenam.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import anzila.binar.challengeenam.adapter.FavoriteAdapter
import anzila.binar.challengeenam.databinding.ActivityFavoriteBinding
import anzila.binar.challengeenam.model.ResponseFilmItem
import anzila.binar.challengeenam.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@Suppress("ReplaceGetOrSet")
@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFavoriteBinding
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var favoriteAdapter: FavoriteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        favoriteViewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)
        favoriteAdapter = FavoriteAdapter()

        binding.rvFavorite.apply {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            adapter = favoriteAdapter
        }

        @Suppress("DEPRECATION")
        val detailFilm = intent.getParcelableExtra("detailfilm") as? ResponseFilmItem
        if (detailFilm != null) {
            favoriteViewModel.addFavoriteFilm(detailFilm)
        }

        val favoriteFilms = favoriteViewModel.getFavoriteFilms()
        favoriteAdapter.submitList(favoriteFilms)
    }
}