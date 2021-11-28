package com.rcflechas.teamsapp.models.data.remote.response

import android.os.Parcelable
import androidx.annotation.Keep
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Keep
@Parcelize
data class TeamsResponse (
    @Json(name = "teams")
    val teams: @RawValue List<TeamResponse> = listOf()
): Parcelable