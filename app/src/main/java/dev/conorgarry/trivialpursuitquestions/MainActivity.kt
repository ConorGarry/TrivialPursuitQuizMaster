package dev.conorgarry.trivialpursuitquestions

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.conorgarry.coreandroid.di.ComponentHolder
import dev.conorgarry.questions.di.QuestionsComponent
import dev.conorgarry.questions.ui.screens.QuestionsFragment
import dev.conorgarry.trivialpursuitquestions.databinding.ActivityMainBinding
import ie.conorgarry.androidcommon.extensions.navigateTo

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        if (savedInstanceState == null) {
            navigateTo(
                QuestionsFragment::class.java,
                bind.fcvMain.id,
                factory = component<QuestionsComponent>().fragmentFactory()
            )
        }
    }
}

// TODO: Move to android-common module.
inline fun <reified T> Context.component(): T = ComponentHolder.component<T>()
