package anzila.binar.challengeenam.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(createdAt)
        parcel.writeString(id)
        parcel.writeString(image)
        parcel.writeString(movieName)
        parcel.writeString(movieRated)
        parcel.writeString(release)
        parcel.writeString(synopsis)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResponseFilmItem> {
        override fun createFromParcel(parcel: Parcel): ResponseFilmItem {
            return ResponseFilmItem(parcel)
        }

        override fun newArray(size: Int): Array<ResponseFilmItem?> {
            return arrayOfNulls(size)
        }
    }
}