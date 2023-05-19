@file:Suppress("MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate"
)

package anzila.binar.challengeenam.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import anzila.binar.challengeenam.databinding.ActivityDetailBinding
import anzila.binar.challengeenam.model.ResponseFilmItem
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection"
)
@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

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

        binding.btnFavorite.setOnClickListener {
            val intent = Intent(this, FavoriteActivity::class.java)
            intent.putExtra("detailfilm", detailFilm)
            startActivity(intent)
        }
    }
}