package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun login(authCredential: AuthCredential): Resource<FirebaseUser>
    suspend fun loginWithEmail(email: String, password: String): Resource<FirebaseUser>
    fun logout()
}