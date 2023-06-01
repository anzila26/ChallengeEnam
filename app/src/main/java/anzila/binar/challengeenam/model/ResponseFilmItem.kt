package anzila.binar.challengeenam.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseFilmItem(
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("movie_name")
    val movieName: String?,
    @SerializedName("movie_rated")
    val movieRated: String?,
    @SerializedName("release")
    val release: String?,
    @SerializedName("synopsis")
    val synopsis: String?
) : Parcelable