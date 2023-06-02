package anzila.binar.challengeenam.viewmodel

import android.app.Application
import android.content.Context
import anzila.binar.challengeenam.model.ResponseFilmItem
import anzila.binar.challengeenam.network.RestfulApi
import anzila.binar.challengeenam.room.FavoriteData
import anzila.binar.challengeenam.room.FavoriteDatabase
import anzila.binar.challengeenam.room.FavoriteDatabaseDao
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call

//class FavoriteViewModelTest {

//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
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
//    fun setUp() {
//        MockitoAnnotations.openMocks(this)
//        Mockito.`when`(application.applicationContext).thenReturn(mock(Context::class.java))
//
//        FavoriteDatabase.setMockInstance(mock(FavoriteDatabase::class.java))
//        Mockito.`when`(FavoriteDatabase.getInstance(application))
//            .thenReturn(mock(FavoriteDatabase::class.java))
//        Mockito.`when`(FavoriteDatabase.getInstance(application)?.favoriteDatabaseDao())
//            .thenReturn(favDao)
//
//        favoriteViewModel = FavoriteViewModel(application)
//    }
//
//    @Test
//    fun testGetAllFavorite() {
//        val favoriteList = listOf(FavoriteData(1, "image1"), FavoriteData(2, "image2"))
//        Mockito.`when`(favDao.getData()).thenReturn(favoriteList)
//
//        favoriteViewModel.getAllFavorite()
//
//        val allFavoriteLiveData = favoriteViewModel.allFavorite.value
//        Assert.assertEquals(favoriteList, allFavoriteLiveData)
//    }
//}