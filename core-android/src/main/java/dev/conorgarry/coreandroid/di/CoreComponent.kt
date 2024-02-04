package dev.conorgarry.coreandroid.di

import android.app.Application
import com.squareup.moshi.Moshi
import dagger.BindsInstance
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface CoreComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: Application
        ): CoreComponent
    }

    fun moshi(): Moshi

    fun retrofit(): Retrofit

    fun okHttpClient(): OkHttpClient
}
