@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("kotlin-kapt")
}

apply(from = "../buildscripts/common-android.gradle")

android {
    namespace = "dev.conorgarry.questions"

    defaultConfig {
        buildConfigField(
            "String",
            "OPEN_API_KEY",
            "\"${System.getenv("OPENAI_API_KEY")}\""
        )
    }
}

dependencies {
    implementation(project(":core-android"))
    implementation(project(":core-serialisation"))
}
