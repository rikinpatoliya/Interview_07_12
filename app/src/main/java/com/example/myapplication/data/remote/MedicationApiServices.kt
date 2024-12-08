package com.example.myapplication.data.remote

import com.example.myapplication.data.models.response.MedicineResponse
import retrofit2.http.POST

interface MedicationApiServices {


    @POST("v3/e58c8d72-1a22-49bc-82eb-655bbb916da0")
    suspend fun getMedications(): MedicineResponse
}