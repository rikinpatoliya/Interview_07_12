package com.example.myapplication.domain.repositories


import javax.inject.Singleton

@Singleton
interface MedicineRepository {

    suspend fun getMedicineList(): Any
//    suspend fun login(baseRequest: BaseRequest<LoginRequest>): ApiResponse<BaseResponse1>
//
//
//    suspend fun verifyOTP1(verifyOTPRequest: BaseRequest<VerifyOTPRequest>): ApiResponse<VerifyOTPResponse>
//
//    suspend fun reSendOTP(loginRequest: BaseRequest<LoginRequest>): ApiResponse<BaseResponse1>
//
//    suspend fun updateFCMToken(fcmTokenRequest: BaseRequest<FCMTokenRequest>): ApiResponse<BaseResponse1>
//
//    suspend fun raiseTicketRequest(raiseTicketRequest: BaseRequest<RaiseTicketRequest>): ApiResponse<Any>

}