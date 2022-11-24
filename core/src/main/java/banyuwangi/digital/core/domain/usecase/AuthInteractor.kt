package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser

class AuthInteractor(private val repository: AuthRepository) : AuthUseCase {

    override val currentUser: FirebaseUser?
        get() = repository.currentUser

    override suspend fun login(email: String, password: String): Resource<FirebaseUser> =
        repository.login(email, password)

    override suspend fun signup(
        name: String,
        email: String,
        password: String
    ): Resource<FirebaseUser> = repository.signup(name, email, password)

    override fun logout() = repository.logout()


}