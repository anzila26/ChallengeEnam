package anzila.binar.challengeenam.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitClient {

    const val  BASE_URL ="https://64548a2df803f345762b1a74.mockapi.io/"

    private  val logging : HttpLoggingInterceptor
        get(){
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

    private val clint = OkHttpClient.Builder().addInterceptor(logging).build()

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit=
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clint)
            .build()

    @Singleton
    @Provides
    fun provideNewsApi(retrofit: Retrofit): RestfulApi =
        retrofit.create(RestfulApi::class.java)
}