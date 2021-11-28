package com.rcflechas.teamsapp.application.di

import com.rcflechas.teamsapp.presentation.viewmodels.TeamsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { TeamsViewModel(androidApplication(), get()) }
}
