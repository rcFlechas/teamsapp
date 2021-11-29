package com.rcflechas.teamsapp.models.data.remote.response

import android.os.Parcelable
import androidx.annotation.Keep
import com.rcflechas.teamsapp.mappers.EntityMapper
import com.rcflechas.teamsapp.models.data.local.entities.TeamEntity
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class TeamResponse(

    @Json(name = "idAPIfootball") val idAPIFootball: String = String(),
    @Json(name = "idLeague") val idLeague: String = String(),
    @Json(name = "idLeague2") val idLeague2: String = String(),
    @Json(name = "idLeague3") val idLeague3: String = String(),
    @Json(name = "idLeague4") val idLeague4: String = String(),
    @Json(name = "idLeague5") val idLeague5: String = String(),
    @Json(name = "idLeague6") val idLeague6: String = String(),
    @Json(name = "idLeague7") val idLeague7: String = String(),
    @Json(name = "idSoccerXML") val idSoccerXML: String = String(),
    @Json(name = "idTeam") val idTeam: String = String(),
    @Json(name = "intFormedYear") val intFormedYear: String = String(),
    @Json(name = "intLoved") val intLoved: String = String(),
    @Json(name = "intStadiumCapacity") val intStadiumCapacity: String = String(),
    @Json(name = "strAlternate") val strAlternate: String = String(),
    @Json(name = "strCountry") val strCountry: String = String(),
    @Json(name = "strDescriptionCN") val strDescriptionCN: String = String(),
    @Json(name = "strDescriptionDE") val strDescriptionDE: String = String(),
    @Json(name = "strDescriptionEN") val strDescriptionEN: String = String(),
    @Json(name = "strDescriptionES") val strDescriptionES: String = String(),
    @Json(name = "strDescriptionFR") val strDescriptionFR: String = String(),
    @Json(name = "strDescriptionHU") val strDescriptionHU: String = String(),
    @Json(name = "strDescriptionIL") val strDescriptionIL: String = String(),
    @Json(name = "strDescriptionIT") val strDescriptionIT: String = String(),
    @Json(name = "strDescriptionJP") val strDescriptionJP: String = String(),
    @Json(name = "strDescriptionNL") val strDescriptionNL: String = String(),
    @Json(name = "strDescriptionNO") val strDescriptionNO: String = String(),
    @Json(name = "strDescriptionPL") val strDescriptionPL: String = String(),
    @Json(name = "strDescriptionPT") val strDescriptionPT: String = String(),
    @Json(name = "strDescriptionRU") val strDescriptionRU: String = String(),
    @Json(name = "strDescriptionSE") val strDescriptionSE: String = String(),
    @Json(name = "strDivision") val strDivision: String = String(),
    @Json(name = "strFacebook") val strFacebook: String = String(),
    @Json(name = "strGender") val strGender: String = String(),
    @Json(name = "strInstagram") val strInstagram: String = String(),
    @Json(name = "strKeywords") val strKeywords: String = String(),
    @Json(name = "strLeague") val strLeague: String = String(),
    @Json(name = "strLeague2") val strLeague2: String = String(),
    @Json(name = "strLeague3") val strLeague3: String = String(),
    @Json(name = "strLeague4") val strLeague4: String = String(),
    @Json(name = "strLeague5") val strLeague5: String = String(),
    @Json(name = "strLeague6") val strLeague6: String = String(),
    @Json(name = "strLeague7") val strLeague7: String = String(),
    @Json(name = "strLocked") val strLocked: String = String(),
    @Json(name = "strManager") val strManager: String = String(),
    @Json(name = "strRSS") val strRSS: String = String(),
    @Json(name = "strSport") val strSport: String = String(),
    @Json(name = "strStadium") val strStadium: String = String(),
    @Json(name = "strStadiumDescription") val strStadiumDescription: String = String(),
    @Json(name = "strStadiumLocation") val strStadiumLocation: String = String(),
    @Json(name = "strStadiumThumb") val strStadiumThumb: String = String(),
    @Json(name = "strTeam") val strTeam: String = String(),
    @Json(name = "strTeamBadge") val strTeamBadge: String = String(),
    @Json(name = "strTeamBanner") val strTeamBanner: String = String(),
    @Json(name = "strTeamFanart1") val strTeamFanart1: String = String(),
    @Json(name = "strTeamFanart2") val strTeamFanart2: String = String(),
    @Json(name = "strTeamFanart3") val strTeamFanart3: String = String(),
    @Json(name = "strTeamFanart4") val strTeamFanart4: String = String(),
    @Json(name = "strTeamJersey") val strTeamJersey: String = String(),
    @Json(name = "strTeamLogo") val strTeamLogo: String = String(),
    @Json(name = "strTeamShort") val strTeamShort: String = String(),
    @Json(name = "strTwitter") val strTwitter: String = String(),
    @Json(name = "strWebsite") val strWebsite: String = String(),
    @Json(name = "strYoutube") val strYoutube: String = String()

) : Parcelable, EntityMapper<TeamResponse, TeamEntity> {

    override fun toEntity() = TeamEntity (
        code = idTeam,
        codeLeague = idLeague,
        leagueName = strLeague,
        name = strTeam,
        description = strDescriptionEN,
        foundedYear = intFormedYear,
        banner = strTeamBanner,
        badge = strTeamBadge,
        jersey = strTeamJersey,
        stadium = strStadium,
        imageStadium = strStadiumThumb,
        website = strWebsite,
        twitter = strTwitter,
        youtube = strYoutube,
        instagram = strInstagram,
        facebook = strFacebook
    )

    override fun List<TeamResponse>.toListEntity() = map(TeamResponse::toEntity)
}