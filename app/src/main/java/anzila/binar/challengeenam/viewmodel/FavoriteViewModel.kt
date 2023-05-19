package anzila.binar.challengeenam.viewmodel

import androidx.lifecycle.ViewModel
import anzila.binar.challengeenam.model.ResponseFilmItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel  @Inject constructor() : ViewModel() {
    private val favoriteFilms: MutableList<ResponseFilmItem> = mutableListOf()

    fun addFavoriteFilm(film: ResponseFilmItem) {
        favoriteFilms.add(film)
    }

    fun getFavoriteFilms(): List<ResponseFilmItem> {
        return favoriteFilms
    }
}