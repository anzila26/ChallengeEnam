package anzila.binar.challengeenam.network

import anzila.binar.challengeenam.model.ResponseFilmItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET ("film")
    fun getAllFilm(): Call<List<ResponseFilmItem>>
}