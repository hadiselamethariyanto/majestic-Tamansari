package banyuwangi.digital.core.data.auth.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.repository.AuthRepository
import banyuwangi.digital.core.utils.await
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRepositoryImpl(private val firebaseAuth: FirebaseAuth) : AuthRepository {
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(authCredential: AuthCredential): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithCredential(authCredential).await()
            Resource.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message.toString())
        }
    }

    override suspend fun loginWithEmail(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user!!)
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }
}