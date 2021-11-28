package com.rcflechas.teamsapp.models.data.local.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rcflechas.teamsapp.mappers.BindMapper
import com.rcflechas.teamsapp.presentation.binds.TeamBind
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "team"
)
@Parcelize
data class TeamEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "team_id")
    val id: Long = 0,

    @ColumnInfo(name = "team_code")
    val code: String,

    @ColumnInfo(name = "team_code_league")
    val codeLeague: String,

    @ColumnInfo(name = "team_league_name")
    val leagueName: String,

    @ColumnInfo(name = "team_name")
    val name: String,

    @ColumnInfo(name = "team_description")
    val description: String,

    @ColumnInfo(name = "team_founded_year")
    val foundedYear: String,

    @ColumnInfo(name = "team_badge")
    val badge: String,

    @ColumnInfo(name = "team_jersey")
    val jersey: String,

    @ColumnInfo(name = "team_stadium")
    val stadium: String,

    @ColumnInfo(name = "team_website")
    val website: String,

    @ColumnInfo(name = "team_twitter")
    val twitter: String,

    @ColumnInfo(name = "team_youtube")
    val youtube: String,

    @ColumnInfo(name = "team_Instagram")
    val instagram: String,

    @ColumnInfo(name = "team_facebook")
    val facebook: String

) : Parcelable, BindMapper<TeamEntity, TeamBind> {

    override fun toBind() = TeamBind(
        id = id,
        code = code,
        codeLeague = codeLeague,
        leagueName = leagueName,
        name = name,
        description = description,
        foundedYear = foundedYear,
        badge = badge,
        jersey = jersey,
        stadium = stadium,
        website = website,
        twitter = twitter,
        youtube = youtube,
        instagram = instagram,
        facebook = facebook
    )
    override fun List<TeamEntity>.toListBind() = map(TeamEntity::toBind)
}
