package com.example.myapplication.di

import com.example.myapplication.constant.AppConst
import com.example.myapplication.data.datasources.remote.MedicineRemoteDataSource
import com.example.myapplication.utils.moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    @Singleton
    fun provideUserService(retrofit: Retrofit): MedicineRemoteDataSource {
        return retrofit
            .create(MedicineRemoteDataSource::class.java)
    }


}
