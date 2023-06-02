package anzila.binar.challengeenam.viewmodel

import anzila.binar.challengeenam.model.ResponseFilmItem
import anzila.binar.challengeenam.network.RestfulApi
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Call

class FilmViewModelTest{
    lateinit var service : RestfulApi

    @Before
    fun setUp(){
        service  = mockk()
    }

    @Test
    fun testRetriveData(): Unit = runBlocking {
        val responseRetrive = mockk<Call<List<ResponseFilmItem>>>()

        every {
            runBlocking {
                service.getAllFilm()
            }
        } returns responseRetrive
        val result = service.getAllFilm()

        verify {
            runBlocking {
                service.getAllFilm()
            }
        }
        assertEquals(result, responseRetrive)
    }
}