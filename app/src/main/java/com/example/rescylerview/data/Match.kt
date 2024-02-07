package com.example.rescylerview.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serial
import java.io.Serializable


data class Match(
    val year: String,
    val stadium:String,
    val homeTeamName:String,
    val awayTeamName:String,
    val homeTeamGoals:String,
    val awayTeamGoals:String,

    ) :Serializable
