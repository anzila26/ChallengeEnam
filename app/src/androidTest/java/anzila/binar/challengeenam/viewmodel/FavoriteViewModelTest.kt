package anzila.binar.challengeenam.viewmodel

import android.app.Application
import androidx.lifecycle.Observer
import anzila.binar.challengeenam.room.FavoriteData
import anzila.binar.challengeenam.room.FavoriteDatabaseDao
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

//@RunWith(MockitoJUnitRunner::class)
//class FavoriteViewModelTest {
//
//    @Mock
//    private lateinit var application: Application
//
//    @Mock
//    private lateinit var favDao: FavoriteDatabaseDao
//
//    private lateinit var favoriteViewModel: FavoriteViewModel
//
//    @Before
//    @Throws(Exception::class)
//    fun setup() {
//        MockitoAnnotations.initMocks(this)
//        favoriteViewModel = FavoriteViewModel(application)
//        favoriteViewModel.allFavorite.observeForever(mock(Observer::class.java) as Observer<List<FavoriteData>>)
//    }
//
//    @Test
//    fun testGetAllFavorite() = runBlocking {
//        val favoriteList = listOf(FavoriteData("1", "image1", "upinipin","","",""), FavoriteData("2", "image2","","","",""))
//        Mockito.`when`(favDao.getData()).thenReturn(favoriteList)
//
//        favoriteViewModel.getAllFavorite()
//
//        val allFavoriteLiveData = favoriteViewModel.allFavorite.value
//        assertEquals(favoriteList, allFavoriteLiveData)
//    }
//}