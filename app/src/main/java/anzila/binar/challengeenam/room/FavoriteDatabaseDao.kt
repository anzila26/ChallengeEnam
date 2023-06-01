package anzila.binar.challengeenam.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteDatabaseDao {

    @Insert
    suspend fun insertData(favoriteData: FavoriteData)

    @Delete
    suspend fun deleteData(favoriteData: FavoriteData)

    @Query("SELECT * FROM FavoriteData")
    suspend fun getData() : List<FavoriteData>
}