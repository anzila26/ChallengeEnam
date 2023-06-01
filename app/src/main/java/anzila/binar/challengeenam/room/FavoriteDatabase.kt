@file:Suppress("unused", "unused", "unused")

package anzila.binar.challengeenam.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoriteData::class], version = 1)
abstract class FavoriteDatabase : RoomDatabase() {

    abstract fun favoriteDatabaseDao() : FavoriteDatabaseDao

    companion object{
        private var INSTANCE : FavoriteDatabase? = null

        fun getInstance(context: Context):FavoriteDatabase? {
            if (INSTANCE == null){
                synchronized(FavoriteDatabase::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FavoriteDatabase::class.java, "favorite.db"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}