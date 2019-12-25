package com.example.readlocaljsonfile.model

import android.os.*
import kotlinx.android.parcel.*

@Parcelize
data class Hero(
    var photo: String?,
    var name: String?,
    var description: String?,
    var original_language: String?,
    var user_score: String?,
    var date: String?,
    var year: String?,
    var runtime: String?,
    var budget: String?,
    var revenue: String?,
    var genres: String?,
    var director: String?,
    var rank_today: Int?,
    var rank_last_week: Int?,
    var status: String?
) : Parcelable