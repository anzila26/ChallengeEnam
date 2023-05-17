package anzila.binar.challengeenam.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import anzila.binar.challengeenam.databinding.ItemFilmBinding
import anzila.binar.challengeenam.model.ResponseFilmItem
import com.bumptech.glide.Glide

class FilmAdapter(var listFilm : List<ResponseFilmItem>): RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    var onClick : ((ResponseFilmItem)->Unit)? = null

    fun setDataFilm(film : List<ResponseFilmItem>){
        this.listFilm = film
    }

    class ViewHolder(var binding: ItemFilmBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmAdapter.ViewHolder {
        var view = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmAdapter.ViewHolder, position: Int) {
        holder.binding.nameFilm.text = listFilm!![position].movieName
        holder.binding.dateFilm.text = listFilm!![position].createdAt
        Glide.with(holder.itemView).load(listFilm!![position].image).into(holder.binding.imgFilm)
        holder.binding.detailFilm.setOnClickListener {
            onClick?.invoke(listFilm!![position])
        }
        // }
    }

    override fun getItemCount(): Int {
        if (listFilm == null){
            return 0
        }
        else{
            return listFilm?.size!!
        }
        //return listFilm!!.size
    }
}