package cheysoff.fanfable.data.remote

import android.net.Uri
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FirebaseCloudDataSource : CloudDataSource {
    private val db = Firebase.firestore
    private val storage = FirebaseStorage.getInstance()
    override suspend fun fetchData(): List<GenreDto> {
        return suspendCoroutine { continuation ->
            db.collection(genreCollectionName)
                .get()
                .addOnSuccessListener { result ->
                    val genreList = mutableListOf<GenreDto>()
                    val downloadTasks = mutableListOf<Task<Uri>>()

                    for (document in result) {
                        val genreName = document.data["genreName"].toString()
                        val genrePicturePath = document.data["genrePicturePath"].toString()

                        val storageRef = storage.reference.child(genrePicturePath)

                        val downloadTask = storageRef.downloadUrl

                        downloadTask.addOnSuccessListener { uri ->
                            val genreDto = GenreDto(genreName, uri.toString())
                            genreList.add(genreDto)

                            if (genreList.size == result.size()) {
                                continuation.resume(genreList)
                            }
                        }

                        downloadTask.addOnFailureListener { exception ->
                            Log.w("cheysoff", "Error downloading image: $exception")
                            return@addOnFailureListener
//                            continuation.resumeWithException(exception)
                        }

                        downloadTasks.add(downloadTask)
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("cheysoff", "Error getting documents.", exception)
                    continuation.resumeWithException(exception)
                }
        }
    }

        // data - document, downloadURi - DIFFERNET FUNCS
    // domain - COMBINED SHIT
    companion object {
        const val genreCollectionName = "storyGenres"
    }
}