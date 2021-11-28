package com.rcflechas.teamsapp.models.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rcflechas.teamsapp.models.data.local.dao.TeamDAO
import com.rcflechas.teamsapp.models.data.local.entities.TeamEntity

@Database(entities = [TeamEntity::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun teamDAO(): TeamDAO
}