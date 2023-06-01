package anzila.binar.challengeenam.viewmodel

import android.app.Application
import androidx.lifecycle.*
import anzila.binar.challengeenam.room.FavoriteData
import anzila.binar.challengeenam.room.FavoriteDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("unused")
@HiltViewModel
class FavoriteViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    private val _allFavorite: MutableLiveData<List<FavoriteData>> = MutableLiveData()
    val allFavorite: LiveData<List<FavoriteData>> = _allFavorite
    init {
        getAllFavorite()
    }

    fun getAllFavorite(){
        viewModelScope.launch {
            val favDao = FavoriteDatabase.getInstance(getApplication())?.favoriteDatabaseDao()
            val listFavorite = favDao?.getData()
            _allFavorite.value = listFavorite
        }
    }

    fun isFavorite(favoriteData: FavoriteData): Boolean {
        val listFavorite = _allFavorite.value
        return listFavorite?.any { it.image == favoriteData.image } ?: false
    }

    fun insertData(entity: FavoriteData){
        viewModelScope.launch {
            val favoriteDao = FavoriteDatabase.getInstance(getApplication())?.favoriteDatabaseDao()
            favoriteDao!!.insertData(entity)
            getAllFavorite()
        }
    }

    fun deleteData(entity: FavoriteData) {
        viewModelScope.launch {
            val favoriteDao = FavoriteDatabase.getInstance(getApplication())?.favoriteDatabaseDao()
            favoriteDao?.deleteData(entity)
            getAllFavorite()
        }
    }
}