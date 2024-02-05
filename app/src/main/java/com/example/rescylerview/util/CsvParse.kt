package com.example.rescylerview.util

import com.example.rescylerview.data.Match

class CsvParse {

   fun parse(lines:String): Match {
        val tokens=lines.split(",")
        return Match(
            year = tokens[Constant.ColumnIndex.YEAR],
            stadium = tokens[Constant.ColumnIndex.STADIUM],
            homeTeamName = tokens[Constant.ColumnIndex.HOME_TEAM_NAME],
            awayTeamName = tokens[Constant.ColumnIndex.AWAY_TEAM_NAME],
            homeTeamGoals =tokens[Constant.ColumnIndex.HOME_TEAM_GOALS],
            awayTeamGoals = tokens[Constant.ColumnIndex.AWAY_TEAM_GOALS]
        )
    }
}