import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    const val composeMaterial = "androidx.compose.material3:material3"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeActivity= "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val composeBom= "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeNavigation= "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    const val composeUiJunit= "androidx.compose.ui:ui-test-junit4"
    const val composeTestManifest= "androidx.compose.ui:ui-test-manifest"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    const val androidxNavigation = "androidx.navigation:navigation-compose:${Versions.androidxNavigation}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"

    const val firebaseStorage = "com.google.firebase:firebase-storage:${Versions.firebaseStorage}"
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseFirestore = "com.google.firebase:firebase-firestore:${Versions.firebaseFirestore}"

    const val coilCompose = "io.coil-kt:coil-compose:${Versions.CoilCompose}"
}


fun DependencyHandler.compose() {
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeActivity)
    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.composeNavigation)
    androidTestImplementation(platform(Dependencies.composeBom))
    androidTestImplementation(Dependencies.composeUiJunit)
    debugImplementation(Dependencies.composeUiTooling)
    debugImplementation(Dependencies.composeTestManifest)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    ksp(Dependencies.hiltCompiler)
    implementation(Dependencies.hiltNavigationCompose)
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.androidxNavigation)
    implementation(Dependencies.hiltNavigationCompose)
}

fun DependencyHandler.firebase() {
    implementation(Dependencies.firebaseStorage)
    implementation(platform(Dependencies.firebaseBom))
    implementation(Dependencies.firebaseFirestore)
}

fun DependencyHandler.coil() {
    implementation(Dependencies.coilCompose)
}

fun DependencyHandler.designSystem() {
    implementation(project(":design-system"))
}