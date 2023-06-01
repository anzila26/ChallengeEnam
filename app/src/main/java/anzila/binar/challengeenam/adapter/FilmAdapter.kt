@file:Suppress("RemoveEmptyClassBody", "RemoveEmptyClassBody", "LiftReturnOrAssignment")

package anzila.binar.challengeenam.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import anzila.binar.challengeenam.databinding.ItemFilmBinding
import anzila.binar.challengeenam.model.ResponseFilmItem
import com.bumptech.glide.Glide

@Suppress("unused", "unused", "unused", "unused", "unused", "unused", "KotlinDeprecation")
class FilmAdapter(private var listFilm : List<ResponseFilmItem>): RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    var onClick : ((ResponseFilmItem)->Unit)? = null

    fun setDataFilm(film : List<ResponseFilmItem>){
        this.listFilm = film
    }

    class ViewHolder(var binding: ItemFilmBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.nameFilm.text = listFilm[position].movieName
        holder.binding.dateFilm.text = listFilm[position].release
        Glide.with(holder.itemView).load(listFilm[position].image).into(holder.binding.imgFilm)
        holder.binding.detailFilm.setOnClickListener {
            onClick?.invoke(listFilm[position])
        }
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }
}