package momolucas.firebaseauthentication.di

import momolucas.firebaseauthentication.repository.LoginRegisterRepository
import momolucas.firebaseauthentication.ui.HomeFragment
import momolucas.firebaseauthentication.ui.LoginUserFragment
import momolucas.firebaseauthentication.ui.RegisterUserFragment
import momolucas.firebaseauthentication.ui.viewmodel.LoginRegisterViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val uiModule = module {
    factory<LoginUserFragment> { LoginUserFragment() }
    factory<RegisterUserFragment> { RegisterUserFragment() }
    factory<HomeFragment> { HomeFragment() }
}

val viewModelModule = module {
    viewModel<LoginRegisterViewModel> { LoginRegisterViewModel(repository = get()) }
}

val repositoryModule = module {
    single<LoginRegisterRepository> { LoginRegisterRepository() }
}