package com.rcflechas.teamsapp.models.data.sources

import com.rcflechas.teamsapp.models.data.local.dao.TeamDAO
import com.rcflechas.teamsapp.models.data.local.entities.TeamEntity
import com.rcflechas.teamsapp.models.data.remote.api.TeamApi
import io.reactivex.Completable

class TeamDataSource(private val teamApi: TeamApi, private val teamDAO: TeamDAO) : TeamLocalDataSource, TeamRemoteDataSource {

    override fun insertAll(teams: List<TeamEntity>) = teamDAO.insertAll(teams)
    override fun getTeamsByLeagueNameRemote(leagueName: String) = teamApi.getTeamsByLeagueName(leagueName)
    override fun getTeamsByLeagueNameLocal(leagueName: String) = teamDAO.getTeamsByLeagueName(leagueName)
}