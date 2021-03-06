package com.rcflechas.teamsapp.models.data.sources

import com.rcflechas.teamsapp.models.data.local.entities.TeamEntity
import io.reactivex.Completable
import io.reactivex.Flowable

interface TeamLocalDataSource {
    fun insertAll(teams: List<TeamEntity>): Completable
    fun getTeamsByLeagueNameLocal(leagueName: String): Flowable<List<TeamEntity>>
}