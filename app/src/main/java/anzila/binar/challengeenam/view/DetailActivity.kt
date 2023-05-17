package anzila.binar.challengeenam.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import anzila.binar.challengeenam.databinding.ActivityDetailBinding
import anzila.binar.challengeenam.model.ResponseFilmItem
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding

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
    }
}