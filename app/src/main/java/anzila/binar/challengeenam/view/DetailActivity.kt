@file:Suppress("MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate"
)

package anzila.binar.challengeenam.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import anzila.binar.challengeenam.databinding.ActivityDetailBinding
import anzila.binar.challengeenam.model.ResponseFilmItem
import anzila.binar.challengeenam.room.FavoriteData
import anzila.binar.challengeenam.room.FavoriteDatabase
import anzila.binar.challengeenam.viewmodel.FavoriteViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@Suppress("DEPRECATION", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "CanBeVal", "CanBeVal", "CanBeVal"
)
@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    lateinit var favoriteViewModel: FavoriteViewModel
    private var favoriteDatabase: FavoriteDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailFilm = intent.getParcelableExtra("detailfilm") as? ResponseFilmItem

        binding.titleDet.text = detailFilm?.movieName
        binding.ratedDet.text = detailFilm?.movieRated
        binding.releaseDet.text = detailFilm?.release
        binding.synopDet.text = detailFilm?.synopsis
        Glide.with(this).load(detailFilm?.image).into(binding.imgDet)

        favoriteDatabase = FavoriteDatabase.getInstance(this)

        favoriteViewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)

        binding.btnFavorite.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                var title = binding.titleDet.text.toString()
                var release = binding.releaseDet.text.toString()
                var image = detailFilm?.image
                var rate = binding.ratedDet.text.toString()
                var synopsis = binding.synopDet.text.toString()
                var id = detailFilm?.id
                val favoriteData = FavoriteData(id!!, image!!, title, release, rate, synopsis)
                val isFavorite = favoriteViewModel.isFavorite(favoriteData)

                if (isFavorite) {
                    favoriteViewModel.deleteData(favoriteData)
                    Toast.makeText(this@DetailActivity, "Film dihapus dari favorit", Toast.LENGTH_SHORT).show()
                } else {
                    favoriteViewModel.insertData(favoriteData)
                    Toast.makeText(this@DetailActivity, "Film berhasil di favoritkan", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}