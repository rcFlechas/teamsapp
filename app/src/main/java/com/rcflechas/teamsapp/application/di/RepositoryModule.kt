package com.rcflechas.teamsapp.application.di

import com.rcflechas.teamsapp.models.repositories.TeamRepository
import com.rcflechas.teamsapp.models.repositories.TeamRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<TeamRepository> { TeamRepositoryImpl(get(), get()) }
}
