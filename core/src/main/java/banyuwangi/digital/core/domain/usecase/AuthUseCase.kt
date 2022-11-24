package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import com.google.firebase.auth.FirebaseUser

interface AuthUseCase {
    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Resource<FirebaseUser>
    suspend fun signup(name: String, email: String, password: String): Resource<FirebaseUser>
    fun logout()
}