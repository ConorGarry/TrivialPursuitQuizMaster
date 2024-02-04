package dev.conorgarry.trivialpursuitquestions.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dev.conorgarry.coreandroid.di.AppScope
import dev.conorgarry.coreandroid.di.CoreComponent
import dev.conorgarry.coreandroid.di.NetworkModule

@AppScope
@Component(modules = [NetworkModule::class], dependencies = [CoreComponent::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: Application,
            coreComponent: CoreComponent
        ): AppComponent
    }
}
