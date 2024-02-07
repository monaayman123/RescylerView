package com.example.rescylerview.ui

import com.example.rescylerview.data.Match

interface MatchInteractionListener {
    fun onClickItem(match: Match)
    fun onClickTeamName(name:String)
    fun deleteItemAtIndex(index:Int)
}