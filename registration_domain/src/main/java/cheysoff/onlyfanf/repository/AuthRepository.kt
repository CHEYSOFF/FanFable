package cheysoff.onlyfanf.repository

import cheysoff.onlyfanf.util.Resource
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {
    val currentUser: FirebaseUser?

    suspend fun firebaseSignUpWithEmailAndPassword(email: String, password: String): Resource<Boolean>

    suspend fun sendEmailVerification(): Resource<Boolean>

    suspend fun firebaseSignInWithEmailAndPassword(email: String, password: String): Resource<Boolean>

    suspend fun reloadFirebaseUser(): Resource<Boolean>

    suspend fun sendPasswordResetEmail(email: String): Resource<Boolean>

    fun signOut()

    suspend fun revokeAccess(): Resource<Boolean>

    fun getAuthState(viewModelScope: CoroutineScope): StateFlow<Boolean>
}