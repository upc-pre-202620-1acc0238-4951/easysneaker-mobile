package pe.edu.upc.easysneaker.features.auth.infrastructure.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthService {

    @Headers("Content-Type: application/json")
    @POST("users/login")
    suspend fun login(
        @Body requestDto: LoginRequestDto
    ): Response<LoginResponseDto>
}