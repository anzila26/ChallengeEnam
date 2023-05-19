@file:Suppress("unused", "unused", "unused", "unused")

package anzila.binar.challengeenam.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import anzila.binar.challengeenam.databinding.ItemFavoriteBinding
import anzila.binar.challengeenam.model.ResponseFilmItem
import com.bumptech.glide.Glide

@Suppress("unused", "unused")
class FavoriteAdapter : ListAdapter<ResponseFilmItem, FavoriteAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteAdapter.ViewHolder {
        val view = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.ViewHolder, position: Int) {
        val film = getItem(position)
        holder.bind(film)
    }

    inner class ViewHolder(private var binding : ItemFavoriteBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(film: ResponseFilmItem){
            binding.nameFilm.text = film.movieName
            binding.dateFilm.text = film.createdAt
            Glide.with(binding.imgFilm)
                .load(film.image)
                .into(binding.imgFilm)
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<ResponseFilmItem>() {
        override fun areItemsTheSame(oldItem: ResponseFilmItem, newItem: ResponseFilmItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResponseFilmItem, newItem: ResponseFilmItem): Boolean {
            return oldItem == newItem
        }
    }
}