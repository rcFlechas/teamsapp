package com.rcflechas.teamsapp.models.repositories

import com.rcflechas.teamsapp.models.data.local.entities.TeamEntity
import com.rcflechas.teamsapp.models.data.sources.TeamLocalDataSource
import com.rcflechas.teamsapp.models.data.sources.TeamRemoteDataSource

class TeamRepositoryImpl(
    private val teamLocalDataSource: TeamLocalDataSource,
    private val teamRemoteDataSource: TeamRemoteDataSource
) : TeamRepository {

    override fun insertAll(teams: List<TeamEntity>) = teamLocalDataSource.insertAll(teams)
    override fun getTeamsByLeagueNameLocal(leagueName: String) = teamLocalDataSource.getTeamsByLeagueNameLocal(leagueName)
    override fun getTeamsByLeagueNameRemote(leagueName: String) = teamRemoteDataSource.getTeamsByLeagueNameRemote(leagueName)
}