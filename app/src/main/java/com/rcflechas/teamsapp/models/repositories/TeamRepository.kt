package com.rcflechas.teamsapp.models.repositories

import com.rcflechas.teamsapp.models.data.local.entities.TeamEntity
import com.rcflechas.teamsapp.models.data.remote.response.TeamsResponse
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface TeamRepository {
    fun insertAll(teams: List<TeamEntity>): Completable
    fun getTeamsByLeagueNameLocal(leagueName: String): Flowable<List<TeamEntity>>
    fun getTeamsByLeagueNameRemote(leagueName: String): Single<TeamsResponse>
}