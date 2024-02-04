package dev.conorgarry.trivialpursuitquestions

import android.app.Application
import dev.conorgarry.coreandroid.di.ComponentHolder
import dev.conorgarry.coreandroid.di.DaggerCoreComponent
import dev.conorgarry.questions.di.DaggerQuestionsComponent
import io.getstream.log.android.AndroidStreamLogger

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidStreamLogger.installOnDebuggableApp(this)

        // Glue Dagger components together.
        val coreComponent = DaggerCoreComponent.factory().create(this)
        ComponentHolder.components.addAll(
            setOf(
                coreComponent,
                DaggerQuestionsComponent.factory().create(coreComponent),
            )
        )
    }
}
