package pe.edu.upc.easysneaker.features.auth.infrastructure.repository

import pe.edu.upc.easysneaker.core.data.local.TokenManager
import pe.edu.upc.easysneaker.features.auth.domain.AuthRepository
import pe.edu.upc.easysneaker.features.auth.domain.User
import pe.edu.upc.easysneaker.features.auth.infrastructure.remote.AuthService
import pe.edu.upc.easysneaker.features.auth.infrastructure.remote.LoginRequestDto
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val service: AuthService,
    private val tokenManager: TokenManager

) : AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Result<User> {
        try {
            val response = service.login(
                LoginRequestDto(
                    email = email,
                    password = password
                )
            )
            if (response.isSuccessful) {
                response.body()?.let { dto ->
                    tokenManager.saveAuthToken(dto.token)
                    return Result.success(
                        User(
                            firstName = dto.firstName,
                            lastName = dto.lastName,
                            email = dto.email
                        )
                    )
                }

            }
            return Result.failure(Exception("Login failed"))
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}