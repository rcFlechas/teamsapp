package com.rcflechas.teamsapp.models.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.rcflechas.teamsapp.models.data.local.entities.TeamEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface TeamDAO : CrudDAO<TeamEntity> {

    @Query("SELECT * FROM team")
    fun getAll(): Maybe<List<TeamEntity>>

    @Query("SELECT * FROM team WHERE team_league_name =:leagueName ")
    fun getTeamsByLeagueName(leagueName: String): Single<List<TeamEntity>>

    @Query("SELECT * FROM team WHERE team_id = :id")
    fun getById(id: Long): Maybe<TeamEntity>

    @Query("DELETE FROM team WHERE team_id = :id")
    fun deleteById(id: Long): Completable

    @Query("DELETE FROM team")
    fun deleteAll(): Completable
}