@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("kotlin-kapt")
}

apply(from = "../buildscripts/common-android.gradle")

android {
    namespace = "dev.conorgarry.trivialpursuitquestions"
}

dependencies {
    implementation(project(":core-android"))
    implementation(project(":questions"))
    implementation(project(":core-serialisation"))
}
