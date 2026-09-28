package pe.edu.upc.easysneaker.features.auth.application

import pe.edu.upc.easysneaker.features.auth.domain.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) =
        authRepository.login(email, password)
}