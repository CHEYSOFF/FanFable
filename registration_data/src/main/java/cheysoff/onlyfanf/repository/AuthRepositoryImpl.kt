package cheysoff.onlyfanf.repository

import cheysoff.onlyfanf.util.Resource
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {
    override val currentUser get() = auth.currentUser

    override suspend fun firebaseSignUpWithEmailAndPassword(
        email: String, password: String
    ) = try {
        auth.createUserWithEmailAndPassword(email, password).await()
        Resource.Success(true)
    } catch (e: Exception) {
        Resource.Error(e.message.orEmpty())
    }

    override suspend fun sendEmailVerification() = try {
        auth.currentUser?.sendEmailVerification()?.await()
        Resource.Success(true)
    } catch (e: Exception) {
        Resource.Error(e.message.orEmpty())
    }

    override suspend fun firebaseSignInWithEmailAndPassword(
        email: String, password: String
    ) = try {
        auth.signInWithEmailAndPassword(email, password).await()
        Resource.Success(true)
    } catch (e: Exception) {
        Resource.Error(e.message.orEmpty())
    }

    override suspend fun reloadFirebaseUser() = try {
        auth.currentUser?.reload()?.await()
        Resource.Success(true)
    } catch (e: Exception) {
        Resource.Error(e.message.orEmpty())
    }

    override suspend fun sendPasswordResetEmail(email: String) = try {
        auth.sendPasswordResetEmail(email).await()
        Resource.Success(true)
    } catch (e: Exception) {
        Resource.Error(e.message.orEmpty())
    }

    override fun signOut() = auth.signOut()

    override suspend fun revokeAccess() = try {
        auth.currentUser?.delete()?.await()
        Resource.Success(true)
    } catch (e: Exception) {
        Resource.Error(e.message.orEmpty())
    }

    override fun getAuthState(viewModelScope: CoroutineScope) = callbackFlow {
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), auth.currentUser == null)
}