package com.rcflechas.teamsapp.models.data.remote.api

import com.rcflechas.teamsapp.models.data.remote.response.TeamsResponse
import com.rcflechas.teamsapp.models.data.remote.rest.TheSportsDB.GET_TEAMS
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamApi {

    @GET(GET_TEAMS)
    fun getTeamsByLeagueName(@Query("l") leagueName: String): Single<TeamsResponse>
}