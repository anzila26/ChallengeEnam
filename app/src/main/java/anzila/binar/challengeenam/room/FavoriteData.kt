package anzila.binar.challengeenam.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class FavoriteData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var image: String,
    var movieName: String,
    var release: String
) : Parcelable
