package banyuwangi.digital.core.domain.usecase.auth

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.repository.AuthRepository
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class AuthInteractor(private val repository: AuthRepository) : AuthUseCase {

    override val currentUser: FirebaseUser?
        get() = repository.currentUser

    override suspend fun login(authCredential: AuthCredential): Resource<FirebaseUser> =
        repository.login(authCredential)

    override suspend fun loginWithEmail(email: String, password: String): Resource<FirebaseUser> =
        repository.loginWithEmail(email, password)

    override fun logout() = repository.logout()


}