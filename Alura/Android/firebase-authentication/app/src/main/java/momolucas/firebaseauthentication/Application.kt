package momolucas.firebaseauthentication

import android.app.Application
import android.content.Context
import momolucas.firebaseauthentication.di.repositoryModule
import momolucas.firebaseauthentication.di.uiModule
import momolucas.firebaseauthentication.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        startKoin {
            androidContext(this@Application)
            modules(
                listOf(
                    uiModule, viewModelModule, repositoryModule
                )
            )
        }
    }
}