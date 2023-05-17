package anzila.binar.challengeenam.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import anzila.binar.challengeenam.model.ResponseFilmItem
import anzila.binar.challengeenam.network.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(var api : RestfulApi) : ViewModel() {
    lateinit var liveDataFilm: MutableLiveData<List<ResponseFilmItem>>

    init {
        liveDataFilm = MutableLiveData()
    }

    fun getliveDataFilm(): MutableLiveData<List<ResponseFilmItem>> {
        return liveDataFilm
    }

    fun callApiFilm(){
       api.getAllFilm()
            .enqueue(object : Callback<List<ResponseFilmItem>> {
                override fun onResponse(
                    call: Call<List<ResponseFilmItem>>,
                    response: Response<List<ResponseFilmItem>>
                ) {
                    if (response.isSuccessful) {
                        liveDataFilm.postValue(response.body())
                        //show data
                    } else {
                        liveDataFilm.postValue(null)
                    }
                }
                override fun onFailure(call: Call<List<ResponseFilmItem>>, t: Throwable) {
                    liveDataFilm.postValue(null)
                }
            })
    }
}