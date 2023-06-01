@file:Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "RemoveRedundantQualifierName", "RemoveRedundantQualifierName", "unused", "unused", "unused",
    "unused"
)

package anzila.binar.challengeenam.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import anzila.binar.challengeenam.databinding.ItemFavoriteBinding
import anzila.binar.challengeenam.model.ResponseFilmItem
import anzila.binar.challengeenam.room.FavoriteData
import com.bumptech.glide.Glide

@Suppress("RemoveEmptyClassBody", "unused", "unused", "unused", "unused")
class FavoriteAdapter (private var listFavorite : List<FavoriteData>): RecyclerView.Adapter<FavoriteAdapter.ViewHolder>(){

    var onClick : ((FavoriteData)->Unit)? = null

    inner class ViewHolder(val binding: ItemFavoriteBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteAdapter.ViewHolder {
        val view = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.ViewHolder, position: Int) {
        holder.binding.nameFilm.text = listFavorite[position].movieName
        holder.binding.dateFilm.text = listFavorite[position].release

        val imageUrl = listFavorite[position].image
        Log.d("FavoriteAdapter", "Image URL: $imageUrl")
        Glide.with(holder.binding.imgFilm.context).load(listFavorite[position].image).into(holder.binding.imgFilm)
        holder.binding.detailFilm.setOnClickListener {
            onClick?.invoke(listFavorite[position])
        }
    }

    override fun getItemCount(): Int {
        return listFavorite.size
    }

    fun setNewData(listFavorite: List<FavoriteData>){
        this.listFavorite=listFavorite
        notifyDataSetChanged()
    }
}