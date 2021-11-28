package com.rcflechas.teamsapp.models.data.sources

import com.rcflechas.teamsapp.models.data.remote.response.TeamsResponse
import io.reactivex.Single

interface TeamRemoteDataSource {
    fun getTeamsByLeagueNameRemote(leagueName: String): Single<TeamsResponse>
}