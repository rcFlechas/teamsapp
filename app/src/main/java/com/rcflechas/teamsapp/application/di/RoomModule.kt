package com.rcflechas.teamsapp.application.di

import androidx.room.Room
import com.rcflechas.teamsapp.models.data.local.DataBase
import org.koin.dsl.module

val roomModule = module {
    single { Room.databaseBuilder(get(), DataBase::class.java, "database_teams").build() }
    single { get<DataBase>().teamDAO() }
}
