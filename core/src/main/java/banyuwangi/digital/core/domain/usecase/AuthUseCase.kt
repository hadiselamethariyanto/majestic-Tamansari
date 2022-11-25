package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser

interface AuthUseCase {
    val currentUser: FirebaseUser?
    suspend fun login(authCredential: AuthCredential): Resource<FirebaseUser>
    fun logout()
}