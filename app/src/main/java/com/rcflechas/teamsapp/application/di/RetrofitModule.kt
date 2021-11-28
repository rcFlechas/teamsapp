package com.rcflechas.teamsapp.application.di

import com.rcflechas.teamsapp.core.RetrofitFactory
import com.rcflechas.teamsapp.models.data.remote.api.TeamApi
import com.rcflechas.teamsapp.models.data.remote.rest.TheSportsDB.URL_BASE
import org.koin.dsl.module


val retrofitModule = module {
    single { RetrofitFactory.retrofit(URL_BASE).create(TeamApi::class.java) }
}
