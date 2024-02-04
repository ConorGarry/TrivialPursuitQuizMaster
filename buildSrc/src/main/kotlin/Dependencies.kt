/**
 * At time of writing this, I couldn't get nested `object` declarations to work.
 * e.g. This should work, but doesn't:
 * ```
 *  object Versions {
 *      object Logging {
 *          const val Timber = "5.0.1
 *      }
 *   }
 * ```
 * Seems to be a known issue: https://github.com/gradle/gradle/issues/9251
 *
 * I'll just use a flattened hierarchy with comments.
 */
object Vrs {
    const val timber = "5.0.1"
    const val moshi = "1.14.0"
    const val retrofit = "2.9.0"
    const val okHttp = "4.9.3"
    const val sqlDelight = "1.5.3"
    const val realm = "1.6.0"
    const val rxJava = "3.1.5"
    const val rxKotlin = "3.0.1"
    const val rxAndroid = "3.1.5"

    // Kotlin
    const val coroutines = "1.6.4"

    // Android
    const val coreKtx = "1.9.0"
    const val fragment = "1.5.3"
    const val activity = "1.6.0"
    const val appCompat = "1.5.1"
    const val material = "1.5.0"
    const val constrLayout = "2.1.3"
    const val lifecycle = "2.5.1"
    const val archCore = "2.1.0"
    const val navigation = "2.5.2"
    const val coreDesugar = "1.2.2"
    const val compose = "1.3.1"
    const val composeCompiler = "1.5.8"
    const val composeBom = "2023.06.01"

    // Testing
    const val junit = "4.13.2"
    const val junitAndroid = "1.1.3"
    const val espresso = "3.3.0"
    const val mockk = "1.13.2"
    const val turbine = "0.11.0"

    // DI
    const val dagger = "2.44"
    const val anvil = "2.3.11" // "2.4.2 - Had issues with 2.4.0, haven't tested it since.
}

object Kotlin {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Vrs.coroutines}"
    const val coroutinesCoreJvm = "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:${Vrs.coroutines}"
    const val coroutinesRx = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Vrs.coroutines}"
}

object Log {
    const val timber = "com.jakewharton.timber:timber:${Vrs.timber}"
}

object Serialisation {
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Vrs.moshi}"
}

object Database {
    const val sqlDelightAndroid = "com.squareup.sqldelight:android-driver:${Vrs.sqlDelight}"
    const val sqlDelightJvm = "com.squareup.sqldelight:sqlite-driver:${Vrs.sqlDelight}"
    const val sqlDelightCoroutines = "com.squareup.sqldelight:coroutines-extensions:${Vrs.sqlDelight}"
    const val realm = "io.realm.kotlin:library-base:${Vrs.realm}"
}

object Network {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Vrs.retrofit}"
    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Vrs.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Vrs.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Vrs.okHttp}"
    const val okHttpMockWebServer = "com.squareup.okhttp3:mockwebserver:${Vrs.okHttp}"
}

object Android {
    const val coreKtx = "androidx.core:core-ktx:${Vrs.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Vrs.appCompat}"
    const val material = "com.google.android.material:material:${Vrs.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Vrs.constrLayout}"
    const val fragment = "androidx.fragment:fragment-ktx:${Vrs.fragment}"
    const val activity = "androidx.activity:activity-ktx:${Vrs.activity}"
    const val fragmentTest = "androidx.fragment:fragment-testing:${Vrs.fragment}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Vrs.lifecycle}"
    const val lifeCycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Vrs.lifecycle}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Vrs.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Vrs.navigation}"
    const val coreDesugar = "com.android.tools:desugar_jdk_libs:${Vrs.coreDesugar}"
}

object Compose {
    const val ui = "androidx.compose.ui:ui:${Vrs.compose}"
    const val compiler = "androidx.compose.compiler:compiler:${Vrs.composeCompiler}"
    // Tooling support (Previews, etc.)
    const val tooling = "androidx.compose.ui:ui-tooling:${Vrs.compose}"
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    const val foundation = "androidx.compose.foundation:foundation:${Vrs.compose}"
    // Material Design
    const val material = "androidx.compose.material:material:${Vrs.compose}"
    // Material design icons
    const val materialIcons = "androidx.compose.material:material-icons-core:${Vrs.compose}"
    const val materialIconsExtended =
        "androidx.compose.material:material-icons-extended:${Vrs.compose}"
    // Integration with activities
    const val activity = "androidx.activity:activity-compose:1.5.1"
    // Integration with ViewModels
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"
    // Integration with observables
    const val liveData = "androidx.compose.runtime:runtime-livedata:${Vrs.compose}"
    const val rxJava2 = "androidx.compose.runtime:runtime-rxjava2:${Vrs.compose}"
    // UI Tests - androidTestImplementation
    const val composeUiTesting = "androidx.compose.ui:ui-test-junit4:1.2.1"
    const val coil = "io.coil-kt:coil-compose:2.4.0"

    const val composeBom = "androidx.compose:compose-bom:${Vrs.composeBom}"
}

object Testing {
    const val junit = "junit:junit:${Vrs.junit}"
    const val junitAndroid = "androidx.test.ext:junit:${Vrs.junitAndroid}"
    const val espresso = "androidx.test.espresso:espresso-core:${Vrs.espresso}"
    const val archCoreTesting = "androidx.arch.core:core-testing:${Vrs.archCore}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Vrs.coroutines}"
    const val mockk = "io.mockk:mockk:${Vrs.mockk}"
    const val turbine = "app.cash.turbine:turbine:${Vrs.turbine}"
}

object DependencyInjection {
    const val dagger = "com.google.dagger:dagger:${Vrs.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Vrs.dagger}"
    const val anvil = "com.squareup.anvil:gradle-plugin:${Vrs.anvil}"
}

object Reactive {
    const val rxJava = "io.reactivex.rxjava3:rxjava:${Vrs.rxJava}"
    const val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Vrs.rxAndroid}"
    const val rxKotlin = "io.reactivex.rxjava3:rxkotlin:${Vrs.rxKotlin}"
}
