package com.rcflechas.teamsapp.application.di

import com.rcflechas.teamsapp.models.data.sources.TeamDataSource
import com.rcflechas.teamsapp.models.data.sources.TeamLocalDataSource
import com.rcflechas.teamsapp.models.data.sources.TeamRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<TeamLocalDataSource> { TeamDataSource(get(), get()) }
    single<TeamRemoteDataSource> { TeamDataSource(get(), get()) }
}
