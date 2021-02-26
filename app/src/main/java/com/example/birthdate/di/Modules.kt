package com.example.birthdate.di

import com.example.birthdate.network.*
import com.example.birthdate.ui.addinfo.AddInfoViewModel
import com.example.birthdate.ui.firstpage.MainViewModel
import com.example.birthdate.ui.showinfo.ShowInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

}

val networkModules = module {
    single { provideLoggingInterceptor() }
    single { provideMoshi() }
    single { provideOkHttp(get()) }
    single { provideRetrofit(get(), get()) }
    single { provideApiService(get()) }
    single { provideMoshiConverterFactory(get()) }

    single<ApiRepository> { ApiRepositoryImp(get()) }
}

val viewModelModule = module {
    viewModel { AddInfoViewModel(get(),get()) }
    viewModel { ShowInfoViewModel() }
    viewModel { MainViewModel() }


}