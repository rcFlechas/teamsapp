package com.rcflechas.teamsapp.presentation.binds

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamBind(
    val id: Long,
    val code: String,
    val codeLeague: String,
    val leagueName: String,
    val name: String,
    val description: String,
    val foundedYear: String,
    val banner: String,
    val badge: String,
    val jersey: String,
    val stadium: String,
    val imageStadium: String,
    val website: String,
    val twitter: String,
    val youtube: String,
    val instagram: String,
    val facebook: String
) : Parcelable {
    companion object{
        const val TAG = "TeamBind"
    }
}
