package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.constant.AppConst
import com.example.myapplication.data.remote.MedicationApiServices
import com.example.myapplication.utils.NetworkUtils
import com.example.myapplication.utils.moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logging)
//            .addInterceptor(
//                Interceptor {
//                    val requestBuilder = it.request().newBuilder()
//                        .addHeader("Content-Type", "application/json")
//                    val token: String = Prefs[Prefs.Keys.TOKEN, ""]
//                    if (token.isNotEmpty()) {
//                        requestBuilder.addHeader("Authorization", "Bearer $token")
//                    }
//                    val request = requestBuilder.build()
//                    it.proceed(request)
//                }
//            )
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(AppConst.API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
    }

    /*  @Provides
      fun provideNotyService(authInterceptor: AuthInterceptor): NotyService {
          return baseRetrofitBuilder
              .client(okHttpClientBuilder.addInterceptor(authInterceptor).build())
              .build()
              .create(NotyService::class.java)
      }*/

    @Provides
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkUtils =
        NetworkUtils(context)

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): MedicationApiServices {
        return retrofit
            .create(MedicationApiServices::class.java)
    }


}
