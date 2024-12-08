package com.example.myapplication.data.datasources.remote

import retrofit2.http.Body
import retrofit2.http.POST

interface MedicineRemoteDataSource {


    @POST("v3/e58c8d72-1a22-49bc-82eb-655bbb916da0")
    suspend fun getMedicineList(
    ): Any
}