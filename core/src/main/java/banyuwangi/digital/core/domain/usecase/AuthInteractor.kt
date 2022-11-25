package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.repository.AuthRepository
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser

class AuthInteractor(private val repository: AuthRepository) : AuthUseCase {

    override val currentUser: FirebaseUser?
        get() = repository.currentUser

    override suspend fun login(authCredential: AuthCredential): Resource<FirebaseUser> =
        repository.login(authCredential)

    override fun logout() = repository.logout()


}