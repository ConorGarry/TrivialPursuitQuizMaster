@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("java-library")
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    api(project(":core-serialisation"))
    api(libs.retrofit)
    api(libs.retrofit.result.adapter)
    api(libs.okhttp)
    api(libs.okhttp.logging.interceptor)
    api(libs.stream.log)
}
